package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  ProgressBar fsc;
  private AppIconView iTC;
  private TextView iTD;
  private TextView iTE;
  private FrameLayout iTF;
  private ImageView iTG;
  private Button iTH;
  private RelativeLayout iTI;
  private TextView iTJ;
  private LinearLayout iTK;
  private TextView iTL;
  j iTM;
  boolean iTN = false;
  private boolean iTO = false;
  ImageView iTe;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void x(long paramLong1, long paramLong2)
  {
    float f2 = (float)paramLong2 / 1.073742E+009F;
    float f1 = (float)paramLong2 / 1048576.0F;
    if (paramLong1 >= paramLong2)
    {
      if (f2 >= 1.0F)
      {
        this.iTE.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        return;
      }
      this.iTE.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      return;
    }
    f2 = (float)paramLong1 / 1048576.0F;
    this.iTE.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    post(new TaskItemView.6(this, (int)(100L * paramLong1 / paramLong2)));
  }
  
  final void aGu()
  {
    this.fsc.setIndeterminate(false);
    com.tencent.mm.plugin.downloader.f.a locala = c.zH(this.iTM.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      x(this.iTM.iSt.iQf, this.iTM.iSt.iQf);
      this.iTF.setVisibility(0);
      this.fsc.setIndeterminate(true);
      this.iTG.setVisibility(8);
      this.iTH.setVisibility(8);
      return;
    }
    x(locala.field_downloadedSize, this.iTM.iSt.iQf);
    if (locala.field_status == 3)
    {
      this.iTF.setVisibility(8);
      this.iTH.setText(b.h.install_app);
      this.iTH.setVisibility(0);
      return;
    }
    if (locala.field_status == 6)
    {
      this.iTF.setVisibility(8);
      this.iTH.setText(getResources().getString(b.h.md5_checking));
      this.iTH.setVisibility(0);
      return;
    }
    this.iTF.setVisibility(0);
    this.fsc.setVisibility(0);
    this.iTH.setVisibility(8);
    if (this.iTN)
    {
      this.iTG.setVisibility(8);
      this.fsc.setIndeterminate(true);
      return;
    }
    if (locala.field_status == 1)
    {
      this.iTN = false;
      this.iTG.setImageResource(b.d.task_pasue);
      this.iTG.setVisibility(0);
      return;
    }
    if ((locala.field_downloadInWifi) && (!aq.isWifi(getContext())))
    {
      this.iTF.setVisibility(8);
      this.iTH.setText(b.h.wait_for_wifi);
      this.iTH.setVisibility(0);
      return;
    }
    if (locala.field_status == 4)
    {
      this.iTF.setVisibility(8);
      this.iTH.setText(b.h.download_retry);
      this.iTH.setVisibility(0);
      return;
    }
    this.iTG.setImageResource(b.d.task_go_on);
    this.iTG.setVisibility(0);
  }
  
  public int getNamePaddingLeft()
  {
    if (this.iTe.getVisibility() == 0) {
      return getResources().getDimensionPixelSize(b.c.checkbox_show_padding);
    }
    return getResources().getDimensionPixelSize(b.c.checkbox_not_show_padding);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.iTe = ((ImageView)findViewById(b.e.check_box));
    this.iTC = ((AppIconView)findViewById(b.e.icon));
    this.iTD = ((TextView)findViewById(b.e.item_name));
    this.iTE = ((TextView)findViewById(b.e.item_size));
    this.iTF = ((FrameLayout)findViewById(b.e.progress_container));
    this.iTF.setOnClickListener(new TaskItemView.1(this));
    this.fsc = ((ProgressBar)findViewById(b.e.progress_bar));
    this.fsc.setSecondaryProgress(100);
    this.iTG = ((ImageView)findViewById(b.e.task_state));
    this.iTH = ((Button)findViewById(b.e.op_button));
    this.iTH.setOnClickListener(new TaskItemView.2(this));
    this.iTI = ((RelativeLayout)findViewById(b.e.update_desc_container));
    this.iTJ = ((TextView)findViewById(b.e.update_desc_text));
    this.iTK = ((LinearLayout)findViewById(b.e.more_container));
    this.iTL = ((TextView)findViewById(b.e.pack_up));
    this.iTL.getViewTreeObserver().addOnGlobalLayoutListener(new TaskItemView.3(this));
    this.iTK.setOnClickListener(new TaskItemView.4(this));
    this.iTL.setOnClickListener(new TaskItemView.5(this));
  }
  
  public void setData(j paramj)
  {
    this.iTM = paramj;
    if (paramj == null) {
      setVisibility(8);
    }
    do
    {
      return;
      setVisibility(0);
      this.iTF.setVisibility(8);
      this.iTH.setVisibility(8);
      this.iTI.setVisibility(8);
      new c.a().erf = true;
      o.ON().a(this.iTM.iconUrl, this.iTC);
      this.iTD.setText(this.iTM.appName);
      if (this.iTM.ilB)
      {
        if (this.iTe.getVisibility() != 0)
        {
          this.iTe.setVisibility(0);
          this.iTe.startAnimation(AnimationUtils.loadAnimation(getContext(), b.a.scale_size));
        }
        setSelected(this.iTM.fmm);
        x(this.iTM.iSt.iQf, this.iTM.iSt.iQf);
        return;
      }
      this.iTe.setVisibility(8);
      x(this.iTM.iSt.iQf, this.iTM.iSt.iQf);
      if (this.iTM.type != 4) {
        break label331;
      }
      paramj = c.zH(this.iTM.appId);
      if ((paramj != null) && (paramj.field_status != 0) && (paramj.field_status != 5)) {
        break;
      }
      this.iTF.setVisibility(8);
      this.iTH.setVisibility(0);
      this.iTH.setText(getContext().getResources().getString(b.h.update_task));
    } while (bk.bl(this.iTM.iSr));
    this.iTI.setVisibility(0);
    this.iTJ.setText(this.iTM.iSr);
    this.iTJ.setMaxLines(2);
    return;
    aGu();
    return;
    label331:
    if (this.iTM.type == 6)
    {
      this.iTF.setVisibility(8);
      this.iTH.setVisibility(0);
      this.iTH.setText(getContext().getResources().getString(b.h.launch_app));
      return;
    }
    aGu();
  }
  
  public void setSelected(boolean paramBoolean)
  {
    y.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.iTM.appId });
    this.iTM.fmm = paramBoolean;
    Object localObject;
    label57:
    h localh;
    int i;
    if (paramBoolean)
    {
      this.iTe.setImageResource(b.d.check_box_selected);
      localObject = getParent();
      if (localObject == null) {
        break label191;
      }
      if (!(localObject instanceof TaskListView)) {
        break label209;
      }
      localObject = (TaskListView)localObject;
      localh = ((TaskListView)localObject).iTW.iTQ;
      Iterator localIterator = localh.iterator();
      i = 0;
      label91:
      if (!localIterator.hasNext()) {
        break label149;
      }
      j localj = (j)localIterator.next();
      if ((!localj.aGp()) || (!localj.fmm)) {
        break label219;
      }
      i += 1;
    }
    label149:
    label191:
    label209:
    label219:
    for (;;)
    {
      break label91;
      this.iTe.setImageResource(b.d.check_box_unselected);
      break;
      if (i > 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        com.tencent.mm.plugin.downloader_app.b.d.eT(paramBoolean);
        if (i != localh.size() - 3) {
          break;
        }
        if ((((TaskListView)localObject).getContext() instanceof DownloadMainUI)) {
          ((DownloadMainUI)((TaskListView)localObject).getContext()).eX(true);
        }
        return;
      }
      ((DownloadMainUI)((TaskListView)localObject).getContext()).eX(false);
      return;
      localObject = ((ViewParent)localObject).getParent();
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */