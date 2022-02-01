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
import com.tencent.mm.av.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.r;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  com.tencent.mm.plugin.downloader_app.a.i oMS;
  ImageView oMu;
  private AppIconView oNc;
  private TextView oNd;
  private TextView oNe;
  private TextView oNf;
  private FrameLayout oNg;
  private ProgressImageView oNh;
  private FrameLayout oNi;
  private Button oNj;
  private Button oNk;
  private DownloadUpdateDescView oNl;
  private LinearLayout oNm;
  private ImageView oNn;
  private TextView oNo;
  boolean oNp = false;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Ww(this.oMS.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.oMS.oLD.oGC;
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
        this.oNf.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.oNf.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.oNf.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.oNh.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == 2131760341)
    {
      this.oNj.setVisibility(8);
      this.oNk.setVisibility(0);
    }
    for (;;)
    {
      this.oNi.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.oNk.setVisibility(8);
      this.oNj.setVisibility(0);
      this.oNj.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    p(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  final void bYH()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    ac.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.oMS.appId });
    this.oNi.setVisibility(8);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Ww(this.oMS.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.oNg.setVisibility(8);
      setButtonText(2131758091);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.oNg.setVisibility(8);
      setButtonText(2131760341);
    }
    for (;;)
    {
      p(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.oNg.setVisibility(8);
        if (e.sg(locala.field_downloadId)) {
          setButtonText(2131761210);
        } else {
          setButtonText(2131760341);
        }
      }
      else
      {
        this.oNg.setVisibility(0);
        if (this.oNp)
        {
          this.oNh.bYF();
        }
        else if (locala.field_status == 1)
        {
          this.oNp = false;
          this.oNh.setProgressColor(2131099699);
          this.oNh.setImageResource(2131690078);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!ax.isWifi(getContext())))
        {
          this.oNg.setVisibility(0);
          this.oNh.bYG();
        }
        else if (locala.field_status == 4)
        {
          this.oNg.setVisibility(8);
          setButtonText(2131758118);
        }
        else
        {
          this.oNh.setProgressColor(2131099734);
          this.oNh.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.oMu.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(2131166044);
      AppMethodBeat.o(9047);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131166043);
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
    this.oMu = ((ImageView)findViewById(2131298219));
    this.oNc = ((AppIconView)findViewById(2131300874));
    this.oNd = ((TextView)findViewById(2131301169));
    this.oNe = ((TextView)findViewById(2131301170));
    this.oNf = ((TextView)findViewById(2131301191));
    this.oNg = ((FrameLayout)findViewById(2131303520));
    this.oNh = ((ProgressImageView)findViewById(2131305673));
    this.oNh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.Ww(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1)
        {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.a(TaskItemView.this));
          AppMethodBeat.o(9028);
          return;
        }
        if (TaskItemView.b(TaskItemView.this).oMW)
        {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
          {
            public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
            {
              AppMethodBeat.i(183827);
              if (paramAnonymous2a != a.a.oKq) {
                TaskItemView.c(TaskItemView.this);
              }
              AppMethodBeat.o(183827);
            }
          });
          AppMethodBeat.o(9028);
          return;
        }
        com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this), new a.b()
        {
          public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
          {
            AppMethodBeat.i(184794);
            if (paramAnonymous2a == a.a.oKq) {
              TaskItemView.c(TaskItemView.this);
            }
            AppMethodBeat.o(184794);
          }
        });
        AppMethodBeat.o(9028);
      }
    });
    this.oNi = ((FrameLayout)findViewById(2131297655));
    this.oNj = ((Button)findViewById(2131303016));
    this.oNj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9031);
        if (TaskItemView.a(TaskItemView.this).type == 6)
        {
          com.tencent.mm.plugin.downloader_app.a.c.c(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
          AppMethodBeat.o(9031);
          return;
        }
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.Ww(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView != null)
        {
          if (TaskItemView.d(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(2131761210)))
          {
            if (!com.tencent.mm.vfs.i.eA(paramAnonymousView.field_filePath))
            {
              com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
              AppMethodBeat.o(9031);
            }
          }
          else
          {
            com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
            AppMethodBeat.o(9031);
          }
        }
        else {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        }
        AppMethodBeat.o(9031);
      }
    });
    this.oNk = ((Button)findViewById(2131301037));
    this.oNk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        AppMethodBeat.o(9033);
      }
    });
    this.oNl = ((DownloadUpdateDescView)findViewById(2131306203));
    this.oNm = ((LinearLayout)findViewById(2131299191));
    this.oNn = ((ImageView)findViewById(2131299193));
    this.oNo = ((TextView)findViewById(2131299192));
    this.oNm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).oLF != null) && (!bs.isNullOrNil(TaskItemView.a(TaskItemView.this).oLF.oGA)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.a(TaskItemView.this).oLF.oGA);
          ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskItemView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.a(TaskItemView.this).position, 40, TaskItemView.a(TaskItemView.this).appId, "", "");
        }
        AppMethodBeat.o(183828);
      }
    });
    AppMethodBeat.o(9040);
  }
  
  public void setData(com.tencent.mm.plugin.downloader_app.a.i parami)
  {
    AppMethodBeat.i(9044);
    this.oMS = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.oNg.setVisibility(8);
    this.oNi.setVisibility(8);
    this.oNl.setVisibility(8);
    this.oNm.setVisibility(8);
    new c.a().hKx = true;
    o.aFB().loadImage(this.oMS.iconUrl, this.oNc);
    this.oNd.setText(this.oMS.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.Ww(this.oMS.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.oNe.setVisibility(0);
    }
    while (this.oMS.nUE)
    {
      if (this.oMu.getVisibility() != 0)
      {
        this.oMu.setVisibility(0);
        this.oMu.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772123));
      }
      setSelected(this.oMS.isSelected);
      setTaskSize(getFileSize());
      AppMethodBeat.o(9044);
      return;
      this.oNe.setVisibility(8);
    }
    this.oMu.setVisibility(8);
    if (this.oMS.oLF != null)
    {
      parami = (LinearLayout.LayoutParams)this.oNm.getLayoutParams();
      if (this.oMS.nUE)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(2131166044);
        this.oNm.setLayoutParams(parami);
        this.oNm.setVisibility(0);
        new c.a().hKx = true;
        o.aFB().loadImage(this.oMS.oLF.drM, this.oNn);
        if (this.oMS.oLF.oGy != null) {
          this.oNo.setText(this.oMS.oLF.oGy.value);
        }
        if (!this.oMS.oLA)
        {
          this.oMS.oLA = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.oMS.position, 1, this.oMS.appId, "", "");
        }
      }
    }
    for (;;)
    {
      setTaskSize(getFileSize());
      this.oNl.setVisibility(8);
      if (this.oMS.type != 4) {
        break label537;
      }
      parami = com.tencent.mm.plugin.downloader.model.d.Ww(this.oMS.appId);
      if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
        break label526;
      }
      this.oNg.setVisibility(8);
      setButtonText(2131764584);
      this.oNl.setData(this.oMS);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(2131166043);
      break;
      this.oNm.setVisibility(8);
    }
    label526:
    bYH();
    AppMethodBeat.o(9044);
    return;
    label537:
    if (this.oMS.type == 6)
    {
      this.oNg.setVisibility(8);
      setButtonText(2131760670);
      AppMethodBeat.o(9044);
      return;
    }
    bYH();
    AppMethodBeat.o(9044);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    ac.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.oMS.appId });
    this.oMS.isSelected = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.e(this.oMu, "checkbox_cell_on");
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
      Iterator localIterator = ((TaskListView)localObject).oNA.oNs.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        com.tencent.mm.plugin.downloader_app.a.i locali = (com.tencent.mm.plugin.downloader_app.a.i)localIterator.next();
        if (!locali.bYu()) {
          break label226;
        }
        if (!locali.isSelected) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.e(this.oMu, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.jL(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).jQ(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).jQ(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */