package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.r;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  ImageView qLZ;
  private AppIconView qMH;
  private TextView qMI;
  private TextView qMJ;
  private TextView qMK;
  private FrameLayout qML;
  private ProgressImageView qMM;
  private FrameLayout qMN;
  private Button qMO;
  private Button qMP;
  private DownloadUpdateDescView qMQ;
  private LinearLayout qMR;
  private ImageView qMS;
  private TextView qMT;
  boolean qMU = false;
  i qMx;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(this.qMx.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.qMx.qLi.qGq;
    AppMethodBeat.o(9048);
    return l;
  }
  
  private void p(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(184795);
    long l = getFileSize();
    float f2 = (float)l / 1.073742E+009F;
    float f1 = (float)l / 1048576.0F;
    if (paramLong >= l)
    {
      if (f2 >= 1.0F)
      {
        this.qMK.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.qMK.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.qMK.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.qMM.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == 2131761786)
    {
      this.qMO.setVisibility(8);
      this.qMP.setVisibility(0);
    }
    for (;;)
    {
      this.qMN.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.qMP.setVisibility(8);
      this.qMO.setVisibility(0);
      this.qMO.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    p(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  final void cCq()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    Log.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.qMx.appId });
    this.qMN.setVisibility(8);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb(this.qMx.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.qML.setVisibility(8);
      setButtonText(2131758351);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.qML.setVisibility(8);
      setButtonText(2131761786);
    }
    for (;;)
    {
      p(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.qML.setVisibility(8);
        if (e.CA(locala.field_downloadId)) {
          setButtonText(2131762997);
        } else {
          setButtonText(2131761786);
        }
      }
      else
      {
        this.qML.setVisibility(0);
        if (this.qMU)
        {
          this.qMM.cCo();
        }
        else if (locala.field_status == 1)
        {
          this.qMU = false;
          this.qMM.setProgressColor(2131099710);
          this.qMM.setImageResource(2131690110);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!NetStatusUtil.isWifi(getContext())))
        {
          this.qML.setVisibility(0);
          this.qMM.setProgressColor(2131099748);
          this.qMM.cCp();
        }
        else if (locala.field_status == 4)
        {
          this.qML.setVisibility(8);
          setButtonText(2131758390);
        }
        else
        {
          this.qMM.setProgressColor(2131099748);
          this.qMM.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.qLZ.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(2131166084);
      AppMethodBeat.o(9047);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131166083);
    AppMethodBeat.o(9047);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(9042);
    super.onAttachedToWindow();
    AppMethodBeat.o(9042);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(9041);
    super.onDetachedFromWindow();
    AppMethodBeat.o(9041);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9040);
    super.onFinishInflate();
    this.qLZ = ((ImageView)findViewById(2131298602));
    this.qMH = ((AppIconView)findViewById(2131302468));
    this.qMI = ((TextView)findViewById(2131302841));
    this.qMJ = ((TextView)findViewById(2131302842));
    this.qMK = ((TextView)findViewById(2131302863));
    this.qML = ((FrameLayout)findViewById(2131306286));
    this.qMM = ((ProgressImageView)findViewById(2131308918));
    this.qMM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.alb(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1) {
          com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9028);
          return;
          if (TaskItemView.b(TaskItemView.this).qMB) {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(183827);
                if (paramAnonymous2a != a.a.qKq) {
                  TaskItemView.c(TaskItemView.this);
                }
                AppMethodBeat.o(183827);
              }
            });
          } else {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this), new a.b()
            {
              public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
              {
                AppMethodBeat.i(184794);
                if (paramAnonymous2a == a.a.qKq) {
                  TaskItemView.c(TaskItemView.this);
                }
                AppMethodBeat.o(184794);
              }
            });
          }
        }
      }
    });
    this.qMN = ((FrameLayout)findViewById(2131297920));
    this.qMO = ((Button)findViewById(2131305612));
    this.qMO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (TaskItemView.a(TaskItemView.this).type == 6) {
          com.tencent.mm.plugin.downloader_app.a.c.d(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(9031);
          return;
          paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.alb(TaskItemView.a(TaskItemView.this).appId);
          if (paramAnonymousView != null)
          {
            if (TaskItemView.d(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(2131762997))) {
              if (s.YS(paramAnonymousView.field_filePath)) {
                continue;
              }
            }
          }
          else
          {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
            continue;
          }
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
      }
    });
    this.qMP = ((Button)findViewById(2131302688));
    this.qMP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.downloader_app.a.c.c(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9033);
      }
    });
    this.qMQ = ((DownloadUpdateDescView)findViewById(2131309601));
    this.qMR = ((LinearLayout)findViewById(2131299742));
    this.qMS = ((ImageView)findViewById(2131299744));
    this.qMT = ((TextView)findViewById(2131299743));
    this.qMR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).qLk != null) && (!Util.isNullOrNil(TaskItemView.a(TaskItemView.this).qLk.qGo)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.a(TaskItemView.this).qLk.qGo);
          ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskItemView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.a(TaskItemView.this).position, 40, TaskItemView.a(TaskItemView.this).appId, "", "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183828);
      }
    });
    AppMethodBeat.o(9040);
  }
  
  public void setData(i parami)
  {
    AppMethodBeat.i(9044);
    this.qMx = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.qML.setVisibility(8);
    this.qMN.setVisibility(8);
    this.qMQ.setVisibility(8);
    this.qMR.setVisibility(8);
    new c.a().jbf = true;
    q.bcV().loadImage(this.qMx.iconUrl, this.qMH);
    this.qMI.setText(this.qMx.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.alb(this.qMx.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.qMJ.setVisibility(0);
    }
    while (this.qMx.pSk)
    {
      if (this.qLZ.getVisibility() != 0)
      {
        this.qLZ.setVisibility(0);
        this.qLZ.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772147));
      }
      setSelected(this.qMx.isSelected);
      setTaskSize(getFileSize());
      AppMethodBeat.o(9044);
      return;
      this.qMJ.setVisibility(8);
    }
    this.qLZ.setVisibility(8);
    if (this.qMx.qLk != null)
    {
      parami = (LinearLayout.LayoutParams)this.qMR.getLayoutParams();
      if (this.qMx.pSk)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(2131166084);
        this.qMR.setLayoutParams(parami);
        this.qMR.setVisibility(0);
        new c.a().jbf = true;
        q.bcV().loadImage(this.qMx.qLk.icon, this.qMS);
        if (this.qMx.qLk.qGm != null) {
          this.qMT.setText(this.qMx.qLk.qGm.value);
        }
        if (!this.qMx.qLf)
        {
          this.qMx.qLf = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.qMx.position, 1, this.qMx.appId, "", "");
        }
      }
    }
    for (;;)
    {
      setTaskSize(getFileSize());
      this.qMQ.setVisibility(8);
      if (this.qMx.type != 4) {
        break label537;
      }
      parami = com.tencent.mm.plugin.downloader.model.d.alb(this.qMx.appId);
      if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
        break label526;
      }
      this.qML.setVisibility(8);
      setButtonText(2131766930);
      this.qMQ.setData(this.qMx);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(2131166083);
      break;
      this.qMR.setVisibility(8);
    }
    label526:
    cCq();
    AppMethodBeat.o(9044);
    return;
    label537:
    if (this.qMx.type == 6)
    {
      this.qML.setVisibility(8);
      setButtonText(2131762201);
      AppMethodBeat.o(9044);
      return;
    }
    cCq();
    AppMethodBeat.o(9044);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    Log.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.qMx.appId });
    this.qMx.isSelected = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.e(this.qLZ, "checkbox_cell_on");
    }
    Object localObject;
    for (;;)
    {
      localObject = getParent();
      if (localObject == null) {
        break label219;
      }
      if (!(localObject instanceof TaskListView)) {
        break label209;
      }
      localObject = (TaskListView)localObject;
      Iterator localIterator = ((TaskListView)localObject).qNf.qMX.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        i locali = (i)localIterator.next();
        if (!locali.cCd()) {
          break label226;
        }
        if (!locali.isSelected) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.e(this.qLZ, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.kY(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).ld(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).ld(false);
      }
      AppMethodBeat.o(9043);
      return;
      localObject = ((ViewParent)localObject).getParent();
      break;
      AppMethodBeat.o(9043);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */