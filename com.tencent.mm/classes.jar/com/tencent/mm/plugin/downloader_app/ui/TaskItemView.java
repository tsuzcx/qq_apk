package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.downloader.c.b.p;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.al;
import java.util.Iterator;

public class TaskItemView
  extends LinearLayout
{
  ProgressBar gJE;
  ImageView lbT;
  private RelativeLayout lcA;
  private TextView lcB;
  private LinearLayout lcC;
  private TextView lcD;
  private LinearLayout lcE;
  private ImageView lcF;
  private TextView lcG;
  private LinearLayout lcH;
  private TextView lcI;
  i lcJ;
  boolean lcK = false;
  private boolean lcL = false;
  private AppIconView lct;
  private TextView lcu;
  private TextView lcv;
  private TextView lcw;
  private FrameLayout lcx;
  private ImageView lcy;
  private Button lcz;
  
  public TaskItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(136278);
    float f2 = (float)paramLong2 / 1.073742E+009F;
    float f1 = (float)paramLong2 / 1048576.0F;
    if (paramLong1 >= paramLong2)
    {
      if (f2 >= 1.0F)
      {
        this.lcw.setText(String.format("%.1fGB", new Object[] { Float.valueOf(f2) }));
        AppMethodBeat.o(136278);
        return;
      }
      this.lcw.setText(String.format("%.1fMB", new Object[] { Float.valueOf(f1) }));
      AppMethodBeat.o(136278);
      return;
    }
    f2 = (float)paramLong1 / 1048576.0F;
    this.lcw.setText(String.format("%.1fMB / %.1fMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) }));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136270);
        TaskItemView.h(TaskItemView.this).setSecondaryProgress(100);
        TaskItemView.h(TaskItemView.this).setProgress(this.gQj);
        AppMethodBeat.o(136270);
      }
    });
    AppMethodBeat.o(136278);
  }
  
  final void bjZ()
  {
    AppMethodBeat.i(136277);
    ab.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", new Object[] { this.lcJ.appId });
    this.gJE.setIndeterminate(false);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JD(this.lcJ.appId);
    if ((locala == null) || (locala.field_status == 5))
    {
      J(this.lcJ.lbb.kWo, this.lcJ.lbb.kWo);
      this.lcx.setVisibility(8);
      this.lcy.setVisibility(8);
      this.lcz.setVisibility(0);
      this.lcz.setText(2131298995);
      AppMethodBeat.o(136277);
      return;
    }
    J(locala.field_downloadedSize, this.lcJ.lbb.kWo);
    if (locala.field_status == 3)
    {
      this.lcx.setVisibility(8);
      this.lcz.setText(2131300740);
      this.lcz.setVisibility(0);
      AppMethodBeat.o(136277);
      return;
    }
    if (locala.field_status == 6)
    {
      this.lcx.setVisibility(8);
      this.lcz.setVisibility(0);
      if (e.iN(locala.field_downloadId))
      {
        this.lcz.setText(getResources().getString(2131301541));
        AppMethodBeat.o(136277);
        return;
      }
      this.lcz.setText(2131300740);
      AppMethodBeat.o(136277);
      return;
    }
    this.lcx.setVisibility(0);
    this.gJE.setVisibility(0);
    this.lcz.setVisibility(8);
    if (this.lcK)
    {
      this.lcy.setVisibility(8);
      this.gJE.setIndeterminate(true);
      AppMethodBeat.o(136277);
      return;
    }
    if (locala.field_status == 1)
    {
      this.lcK = false;
      this.lcy.setImageResource(2130840547);
      this.lcy.setVisibility(0);
      AppMethodBeat.o(136277);
      return;
    }
    if ((locala.field_reserveInWifi) && (!at.isWifi(getContext())))
    {
      this.lcx.setVisibility(8);
      this.lcz.setText(2131304771);
      this.lcz.setVisibility(0);
      AppMethodBeat.o(136277);
      return;
    }
    if (locala.field_status == 4)
    {
      this.lcx.setVisibility(8);
      this.lcz.setText(2131299015);
      this.lcz.setVisibility(0);
      AppMethodBeat.o(136277);
      return;
    }
    this.lcy.setImageResource(2130840546);
    this.lcy.setVisibility(0);
    AppMethodBeat.o(136277);
  }
  
  public int getNamePaddingLeft()
  {
    AppMethodBeat.i(136279);
    if (this.lbT.getVisibility() == 0)
    {
      i = getResources().getDimensionPixelSize(2131428233);
      AppMethodBeat.o(136279);
      return i;
    }
    int i = getResources().getDimensionPixelSize(2131428232);
    AppMethodBeat.o(136279);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(136274);
    super.onAttachedToWindow();
    AppMethodBeat.o(136274);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(136273);
    super.onDetachedFromWindow();
    AppMethodBeat.o(136273);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136272);
    super.onFinishInflate();
    this.lbT = ((ImageView)findViewById(2131823367));
    this.lct = ((AppIconView)findViewById(2131820929));
    this.lcu = ((TextView)findViewById(2131823433));
    this.lcv = ((TextView)findViewById(2131823434));
    this.lcw = ((TextView)findViewById(2131823435));
    this.lcx = ((FrameLayout)findViewById(2131823436));
    this.gJE = ((ProgressBar)findViewById(2131821119));
    this.gJE.setOnClickListener(new TaskItemView.1(this));
    this.gJE.setSecondaryProgress(100);
    this.lcy = ((ImageView)findViewById(2131823437));
    this.lcy.setOnClickListener(new TaskItemView.3(this));
    this.lcz = ((Button)findViewById(2131823438));
    this.lcz.setOnClickListener(new TaskItemView.4(this));
    this.lcA = ((RelativeLayout)findViewById(2131823439));
    this.lcB = ((TextView)findViewById(2131823441));
    this.lcC = ((LinearLayout)findViewById(2131823442));
    this.lcD = ((TextView)findViewById(2131823443));
    this.lcD.getViewTreeObserver().addOnGlobalLayoutListener(new TaskItemView.5(this));
    this.lcC.setOnClickListener(new TaskItemView.6(this));
    this.lcD.setOnClickListener(new TaskItemView.7(this));
    this.lcE = ((LinearLayout)findViewById(2131823444));
    this.lcF = ((ImageView)findViewById(2131823445));
    this.lcG = ((TextView)findViewById(2131823446));
    this.lcH = ((LinearLayout)findViewById(2131823447));
    this.lcH.setOnClickListener(new TaskItemView.8(this));
    this.lcI = ((TextView)findViewById(2131823448));
    AppMethodBeat.o(136272);
  }
  
  public void setData(i parami)
  {
    AppMethodBeat.i(136276);
    this.lcJ = parami;
    if (parami == null)
    {
      setVisibility(8);
      AppMethodBeat.o(136276);
      return;
    }
    setVisibility(0);
    this.lcx.setVisibility(8);
    this.lcz.setVisibility(8);
    this.lcA.setVisibility(8);
    this.lcE.setVisibility(8);
    new c.a().eNM = true;
    o.ahG().a(this.lcJ.iconUrl, this.lct);
    this.lcu.setText(this.lcJ.appName);
    parami = com.tencent.mm.plugin.downloader.model.d.JD(this.lcJ.appId);
    if ((parami != null) && (parami.field_autoDownload)) {
      this.lcv.setVisibility(0);
    }
    while (this.lcJ.kmz)
    {
      if (this.lbT.getVisibility() != 0)
      {
        this.lbT.setVisibility(0);
        this.lbT.startAnimation(AnimationUtils.loadAnimation(getContext(), 2131034245));
      }
      setSelected(this.lcJ.gDG);
      J(this.lcJ.lbb.kWo, this.lcJ.lbb.kWo);
      AppMethodBeat.o(136276);
      return;
      this.lcv.setVisibility(8);
    }
    this.lbT.setVisibility(8);
    if (this.lcJ.lbd != null)
    {
      parami = (LinearLayout.LayoutParams)this.lcE.getLayoutParams();
      if (this.lcJ.kmz) {
        parami.leftMargin = al.fromDPToPix(getContext(), 114);
      }
    }
    for (;;)
    {
      this.lcE.setLayoutParams(parami);
      this.lcE.setVisibility(0);
      new c.a().eNM = true;
      o.ahG().a(this.lcJ.lbd.cDz, this.lcF);
      if (this.lcJ.lbd.kWk != null) {
        this.lcG.setText(this.lcJ.lbd.kWk.value);
      }
      try
      {
        this.lcG.setTextColor(Color.parseColor(this.lcJ.lbd.kWk.color));
        label396:
        if (this.lcJ.lbd.kWl != null)
        {
          this.lcH.setVisibility(0);
          this.lcI.setText(this.lcJ.lbd.kWl.value);
        }
        try
        {
          this.lcI.setTextColor(Color.parseColor(this.lcJ.lbd.kWl.color));
          label460:
          if (!this.lcJ.laY)
          {
            this.lcJ.laY = true;
            com.tencent.mm.plugin.downloader_app.c.a.a(10, 1006, this.lcJ.position, 1, this.lcJ.appId, "", "");
          }
          for (;;)
          {
            J(this.lcJ.lbb.kWo, this.lcJ.lbb.kWo);
            if (this.lcJ.type != 4) {
              break label710;
            }
            parami = com.tencent.mm.plugin.downloader.model.d.JD(this.lcJ.appId);
            if ((parami != null) && (parami.field_status != 0) && (parami.field_status != 5)) {
              break label699;
            }
            this.lcx.setVisibility(8);
            this.lcz.setVisibility(0);
            this.lcz.setText(getContext().getResources().getString(2131304438));
            if (bo.isNullOrNil(this.lcJ.laZ)) {
              break label703;
            }
            this.lcA.setVisibility(0);
            this.lcB.setText(this.lcJ.laZ);
            this.lcB.setMaxLines(2);
            AppMethodBeat.o(136276);
            return;
            parami.leftMargin = al.fromDPToPix(getContext(), 78);
            break;
            this.lcH.setVisibility(8);
            break label460;
            this.lcE.setVisibility(8);
          }
          label699:
          bjZ();
          label703:
          AppMethodBeat.o(136276);
          return;
          label710:
          if (this.lcJ.type == 6)
          {
            this.lcx.setVisibility(8);
            this.lcz.setVisibility(0);
            this.lcz.setText(getContext().getResources().getString(2131301053));
            AppMethodBeat.o(136276);
            return;
          }
          bjZ();
          AppMethodBeat.o(136276);
          return;
        }
        catch (Exception parami)
        {
          break label460;
        }
      }
      catch (Exception parami)
      {
        break label396;
      }
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(136275);
    ab.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", new Object[] { Boolean.valueOf(paramBoolean), this.lcJ.appId });
    this.lcJ.gDG = paramBoolean;
    Object localObject;
    label62:
    h localh;
    int i;
    if (paramBoolean)
    {
      this.lbT.setImageResource(2130838378);
      localObject = getParent();
      if (localObject == null) {
        break label236;
      }
      if (!(localObject instanceof TaskListView)) {
        break label226;
      }
      localObject = (TaskListView)localObject;
      localh = ((TaskListView)localObject).lcX.lcP;
      Iterator localIterator = localh.iterator();
      i = 0;
      label96:
      if (!localIterator.hasNext()) {
        break label154;
      }
      i locali = (i)localIterator.next();
      if ((!locali.bjS()) || (!locali.gDG)) {
        break label243;
      }
      i += 1;
    }
    label154:
    label219:
    label226:
    label236:
    label243:
    for (;;)
    {
      break label96;
      this.lbT.setImageResource(2130838379);
      break;
      if (i > 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        com.tencent.mm.plugin.downloader_app.b.d.gw(paramBoolean);
        if (i != localh.size() - 3) {
          break;
        }
        if (!(((TaskListView)localObject).getContext() instanceof DownloadMainUI)) {
          break label219;
        }
        ((DownloadMainUI)((TaskListView)localObject).getContext()).gA(true);
        AppMethodBeat.o(136275);
        return;
      }
      ((DownloadMainUI)((TaskListView)localObject).getContext()).gA(false);
      AppMethodBeat.o(136275);
      return;
      localObject = ((ViewParent)localObject).getParent();
      break label62;
      AppMethodBeat.o(136275);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView
 * JD-Core Version:    0.7.0.1
 */