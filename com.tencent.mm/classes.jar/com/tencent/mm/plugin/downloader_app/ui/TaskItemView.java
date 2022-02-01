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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.r;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  ImageView oiU;
  private AppIconView ojC;
  private TextView ojD;
  private TextView ojE;
  private TextView ojF;
  private FrameLayout ojG;
  private ProgressImageView ojH;
  private FrameLayout ojI;
  private Button ojJ;
  private Button ojK;
  private DownloadUpdateDescView ojL;
  private LinearLayout ojM;
  private ImageView ojN;
  private TextView ojO;
  boolean ojP = false;
  com.tencent.mm.plugin.downloader_app.a.i ojs;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private long getFileSize()
  {
    AppMethodBeat.i(9048);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Sk(this.ojs.appId);
    if ((locala != null) && (locala.field_fileSize > 0L))
    {
      l = locala.field_fileSize;
      AppMethodBeat.o(9048);
      return l;
    }
    long l = this.ojs.oid.odd;
    AppMethodBeat.o(9048);
    return l;
  }
  
  private void o(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(184795);
    long l = getFileSize();
    float f2 = (float)l / 1.073742E+009F;
    float f1 = (float)l / 1048576.0F;
    if (paramLong >= l)
    {
      if (f2 >= 1.0F)
      {
        this.ojF.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(184795);
        return;
      }
      this.ojF.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(184795);
      return;
    }
    f2 = (float)paramLong / 1048576.0F;
    this.ojF.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    if (paramBoolean)
    {
      int i = (int)(100L * paramLong / l);
      this.ojH.setProgress(i);
    }
    AppMethodBeat.o(184795);
  }
  
  private void setButtonText(int paramInt)
  {
    AppMethodBeat.i(183831);
    if (paramInt == 2131760341)
    {
      this.ojJ.setVisibility(8);
      this.ojK.setVisibility(0);
    }
    for (;;)
    {
      this.ojI.setVisibility(0);
      AppMethodBeat.o(183831);
      return;
      this.ojK.setVisibility(8);
      this.ojJ.setVisibility(0);
      this.ojJ.setText(paramInt);
    }
  }
  
  private void setTaskSize(long paramLong)
  {
    AppMethodBeat.i(9046);
    o(paramLong, false);
    AppMethodBeat.o(9046);
  }
  
  final void bRs()
  {
    boolean bool = false;
    AppMethodBeat.i(9045);
    ad.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.ojs.appId });
    this.ojI.setVisibility(8);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Sk(this.ojs.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      setTaskSize(getFileSize());
      this.ojG.setVisibility(8);
      setButtonText(2131758091);
      AppMethodBeat.o(9045);
      return;
    }
    if (locala.field_status == 3)
    {
      this.ojG.setVisibility(8);
      setButtonText(2131760341);
    }
    for (;;)
    {
      o(locala.field_downloadedSize, bool);
      AppMethodBeat.o(9045);
      return;
      if (locala.field_status == 6)
      {
        this.ojG.setVisibility(8);
        if (e.ou(locala.field_downloadId)) {
          setButtonText(2131761210);
        } else {
          setButtonText(2131760341);
        }
      }
      else
      {
        this.ojG.setVisibility(0);
        if (this.ojP)
        {
          this.ojH.bRq();
        }
        else if (locala.field_status == 1)
        {
          this.ojP = false;
          this.ojH.setProgressColor(2131099699);
          this.ojH.setImageResource(2131690078);
          bool = true;
        }
        else if ((locala.field_reserveInWifi) && (!ay.isWifi(getContext())))
        {
          this.ojG.setVisibility(0);
          this.ojH.bRr();
        }
        else if (locala.field_status == 4)
        {
          this.ojG.setVisibility(8);
          setButtonText(2131758118);
        }
        else
        {
          this.ojH.setProgressColor(2131099734);
          this.ojH.setImageResource("download_app_pause");
          bool = true;
        }
      }
    }
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(9047);
    if (this.oiU.getVisibility() == 0)
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
    this.oiU = ((ImageView)findViewById(2131298219));
    this.ojC = ((AppIconView)findViewById(2131300874));
    this.ojD = ((TextView)findViewById(2131301169));
    this.ojE = ((TextView)findViewById(2131301170));
    this.ojF = ((TextView)findViewById(2131301191));
    this.ojG = ((FrameLayout)findViewById(2131303520));
    this.ojH = ((ProgressImageView)findViewById(2131305673));
    this.ojH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9028);
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.Sk(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView.field_status == 1)
        {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.a(TaskItemView.this));
          AppMethodBeat.o(9028);
          return;
        }
        if (TaskItemView.b(TaskItemView.this).ojw)
        {
          com.tencent.mm.plugin.downloader_app.a.c.a(TaskItemView.this.getContext(), paramAnonymousView.field_downloadId, new a.b()
          {
            public final void a(a.a paramAnonymous2a, long paramAnonymous2Long)
            {
              AppMethodBeat.i(183827);
              if (paramAnonymous2a != a.a.ogQ) {
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
            if (paramAnonymous2a == a.a.ogQ) {
              TaskItemView.c(TaskItemView.this);
            }
            AppMethodBeat.o(184794);
          }
        });
        AppMethodBeat.o(9028);
      }
    });
    this.ojI = ((FrameLayout)findViewById(2131297655));
    this.ojJ = ((Button)findViewById(2131303016));
    this.ojJ.setOnClickListener(new View.OnClickListener()
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
        paramAnonymousView = com.tencent.mm.plugin.downloader.model.d.Sk(TaskItemView.a(TaskItemView.this).appId);
        if (paramAnonymousView != null)
        {
          if (TaskItemView.d(TaskItemView.this).getText().equals(TaskItemView.this.getResources().getString(2131761210)))
          {
            if (!com.tencent.mm.vfs.i.eK(paramAnonymousView.field_filePath))
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
    this.ojK = ((Button)findViewById(2131301037));
    this.ojK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9033);
        com.tencent.mm.plugin.downloader_app.a.c.b(TaskItemView.this.getContext(), TaskItemView.a(TaskItemView.this));
        AppMethodBeat.o(9033);
      }
    });
    this.ojL = ((DownloadUpdateDescView)findViewById(2131306203));
    this.ojM = ((LinearLayout)findViewById(2131299191));
    this.ojN = ((ImageView)findViewById(2131299193));
    this.ojO = ((TextView)findViewById(2131299192));
    this.ojM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183828);
        if ((TaskItemView.a(TaskItemView.this) != null) && (TaskItemView.a(TaskItemView.this).oif != null) && (!bt.isNullOrNil(TaskItemView.a(TaskItemView.this).oif.odb)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", TaskItemView.a(TaskItemView.this).oif.odb);
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
    this.ojs = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(9044);
      return;
    }
    setVisibility(0);
    this.ojG.setVisibility(8);
    this.ojI.setVisibility(8);
    this.ojL.setVisibility(8);
    this.ojM.setVisibility(8);
    new c.a().hjU = true;
    o.ayJ().loadImage(this.ojs.iconUrl, this.ojC);
    this.ojD.setText(this.ojs.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.Sk(this.ojs.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.ojE.setVisibility(0);
    }
    while (this.ojs.nrE)
    {
      if (this.oiU.getVisibility() != 0)
      {
        this.oiU.setVisibility(0);
        this.oiU.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772123));
      }
      setSelected(this.ojs.ira);
      setTaskSize(getFileSize());
      AppMethodBeat.o(9044);
      return;
      this.ojE.setVisibility(8);
    }
    this.oiU.setVisibility(8);
    if (this.ojs.oif != null)
    {
      parami = (LinearLayout.LayoutParams)this.ojM.getLayoutParams();
      if (this.ojs.nrE)
      {
        parami.leftMargin = getResources().getDimensionPixelSize(2131166044);
        this.ojM.setLayoutParams(parami);
        this.ojM.setVisibility(0);
        new c.a().hjU = true;
        o.ayJ().loadImage(this.ojs.oif.dub, this.ojN);
        if (this.ojs.oif.ocZ != null) {
          this.ojO.setText(this.ojs.oif.ocZ.value);
        }
        if (!this.ojs.oia)
        {
          this.ojs.oia = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.ojs.position, 1, this.ojs.appId, "", "");
        }
      }
    }
    for (;;)
    {
      setTaskSize(getFileSize());
      this.ojL.setVisibility(8);
      if (this.ojs.type != 4) {
        break label537;
      }
      parami = com.tencent.mm.plugin.downloader.model.d.Sk(this.ojs.appId);
      if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
        break label526;
      }
      this.ojG.setVisibility(8);
      setButtonText(2131764584);
      this.ojL.setData(this.ojs);
      AppMethodBeat.o(9044);
      return;
      parami.leftMargin = getResources().getDimensionPixelSize(2131166043);
      break;
      this.ojM.setVisibility(8);
    }
    label526:
    bRs();
    AppMethodBeat.o(9044);
    return;
    label537:
    if (this.ojs.type == 6)
    {
      this.ojG.setVisibility(8);
      setButtonText(2131760670);
      AppMethodBeat.o(9044);
      return;
    }
    bRs();
    AppMethodBeat.o(9044);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(9043);
    ad.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.ojs.appId });
    this.ojs.ira = paramBoolean;
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.b.e(this.oiU, "checkbox_cell_on");
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
      Iterator localIterator = ((TaskListView)localObject).oka.ojS.iterator();
      paramBoolean = false;
      i = 1;
      for (;;)
      {
        label94:
        if (!localIterator.hasNext()) {
          break label155;
        }
        com.tencent.mm.plugin.downloader_app.a.i locali = (com.tencent.mm.plugin.downloader_app.a.i)localIterator.next();
        if (!locali.bRf()) {
          break label226;
        }
        if (!locali.ira) {
          break;
        }
        paramBoolean = true;
      }
      com.tencent.mm.plugin.downloader_app.b.e(this.oiU, "checkbox_cell_off");
    }
    int i = 0;
    label155:
    label209:
    label219:
    label226:
    for (;;)
    {
      break label94;
      com.tencent.mm.plugin.downloader_app.a.d.ji(paramBoolean);
      if (i != 0)
      {
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI))
        {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).jn(true);
          AppMethodBeat.o(9043);
        }
      }
      else {
        ((DownloadMainUI)((TaskListView)localObject).getContext()).jn(false);
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