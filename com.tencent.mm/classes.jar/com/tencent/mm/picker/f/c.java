package com.tencent.mm.picker.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.i;
import com.tencent.mm.picker.a.d;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.f;
import com.tencent.mm.ui.bc;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class c
  extends a
  implements View.OnClickListener
{
  private String TAG;
  private Context context;
  public e pzv;
  public boolean pzw;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.pzw = false;
    this.pzv = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.pyC = parama;
    Object localObject5 = parama.context;
    bTc();
    bSZ();
    bTa();
    LayoutInflater.from((Context)localObject5).inflate(a.g.mm_pickerview_time, this.pzi);
    Object localObject1 = (TextView)findViewById(a.f.tvTitle);
    Object localObject2 = (RelativeLayout)findViewById(a.f.rv_topbar);
    Object localObject3 = (Button)findViewById(a.f.btnSubmit);
    Object localObject4 = (Button)findViewById(a.f.btnCancel);
    ((Button)localObject3).setTag("submit");
    ((Button)localObject4).setTag("cancel");
    ((Button)localObject3).setOnClickListener(this);
    ((Button)localObject4).setOnClickListener(this);
    label174:
    label196:
    int i;
    label489:
    int j;
    int k;
    label570:
    int i1;
    label645:
    int n;
    int m;
    if (TextUtils.isEmpty(this.pyC.pyV))
    {
      parama = ((Context)localObject5).getResources().getString(a.i.pickerview_submit);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.pyC.pyW)) {
        break label1334;
      }
      parama = ((Context)localObject5).getResources().getString(a.i.pickerview_cancel);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.pyC.pyX)) {
        break label1345;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.pyC.pyY);
      ((Button)localObject4).setTextColor(this.pyC.pyZ);
      ((TextView)localObject1).setTextColor(this.pyC.pza);
      ((RelativeLayout)localObject2).setBackgroundColor(this.pyC.pzc);
      ((Button)localObject3).setTextSize(this.pyC.pzd);
      ((Button)localObject4).setTextSize(this.pyC.pzd);
      ((TextView)localObject1).setTextSize(this.pyC.pze);
      parama = this.pzv;
      localObject1 = this.pyC.pyK;
      i = this.pyC.pyU;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.pyK = ((boolean[])localObject1);
      parama.fl = i;
      if (this.pyC.pyG != null) {
        this.pzv.pzT = new com.tencent.mm.picker.d.a()
        {
          public final void bSX()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.dateFormat.parse(c.b(c.this).getTime());
              c.this.pyC.pyG.bSY();
              AppMethodBeat.o(175352);
              return;
            }
            catch (ParseException localParseException)
            {
              bc.printErrStackTrace(c.c(c.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(175352);
            }
          }
        };
      }
      if ((this.pyC.startYear != 0) && (this.pyC.endYear != 0) && (this.pyC.startYear <= this.pyC.endYear))
      {
        this.pzv.startYear = this.pyC.startYear;
        this.pzv.endYear = this.pyC.endYear;
      }
      if ((this.pyC.pyM == null) || (this.pyC.pyN == null)) {
        break label1356;
      }
      if (this.pyC.pyM.getTimeInMillis() > this.pyC.pyN.getTimeInMillis())
      {
        bc.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.pyC.pyM = null;
      }
      parama = this.pzv;
      localObject1 = this.pyC.pyM;
      localObject2 = this.pyC.pyN;
      if ((localObject1 != null) || (localObject2 == null)) {
        break label1531;
      }
      i = ((Calendar)localObject2).get(1);
      j = ((Calendar)localObject2).get(2) + 1;
      k = ((Calendar)localObject2).get(5);
      if (i <= parama.startYear) {
        break label1460;
      }
      parama.endYear = i;
      parama.pzL = j;
      parama.pzN = k;
      if (!this.pzw)
      {
        if ((this.pyC.pyM == null) || (this.pyC.pyN == null)) {
          break label1825;
        }
        if ((this.pyC.pyL != null) && (this.pyC.pyL.getTimeInMillis() >= this.pyC.pyM.getTimeInMillis())) {
          break label1784;
        }
        this.pyC.pyL = this.pyC.pyM;
      }
      if (this.pyC.pyL != null) {
        break label1879;
      }
      parama = Calendar.getInstance();
      parama.setTimeInMillis(System.currentTimeMillis());
      i = parama.get(1);
      i1 = parama.get(2);
      n = parama.get(5);
      m = parama.get(11);
      k = parama.get(12);
      j = parama.get(13);
      label709:
      parama = this.pzv;
      parama.pzS = i;
      parama.pzD = ((WheelView)parama.view.findViewById(a.f.year));
      parama.pzE = ((WheelView)parama.view.findViewById(a.f.month));
      parama.pzF = ((WheelView)parama.view.findViewById(a.f.day));
      parama.pzJ = new d(parama.startYear, parama.endYear, parama.ctx);
      parama.pzD.setAdapter(parama.pzJ);
      parama.pzD.setCurrentItem(i - parama.startYear);
      parama.pzD.setGravity(parama.fl);
      if (parama.startYear != parama.endYear) {
        break label1961;
      }
      parama.pzE.setAdapter(new com.tencent.mm.picker.a.c(parama.pzK, parama.pzL, new com.tencent.mm.picker.a.b(parama.ctx)));
      parama.pzE.setCurrentItem(i1 + 1 - parama.pzK);
      label888:
      parama.pzE.setGravity(parama.fl);
      if (!parama.pyg) {
        break label3667;
      }
    }
    label1334:
    label1345:
    label1356:
    label3277:
    label3667:
    for (int i2 = i - 1;; i2 = i)
    {
      if ((parama.startYear == parama.endYear) && (parama.pzK == parama.pzL)) {
        if (parama.pzW.contains(String.valueOf(i1 + 1)))
        {
          if (parama.pzN > 31) {
            parama.pzN = 31;
          }
          parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, parama.pzN));
          label989:
          parama.pzF.setCurrentItem(n - parama.pzM);
          parama.pzF.setGravity(parama.fl);
          parama.pzG = ((WheelView)parama.view.findViewById(a.f.hour));
          parama.pzG.setAdapter(new com.tencent.mm.picker.a.c(parama.pzO, parama.pzQ));
          parama.pzG.setCurrentItem(m - parama.pzO);
          parama.pzG.setGravity(parama.fl);
          parama.pzH = ((WheelView)parama.view.findViewById(a.f.min));
          if ((m != parama.pzO) || (parama.pzO != parama.pzQ)) {
            break label2956;
          }
          parama.pzH.setAdapter(new com.tencent.mm.picker.a.c(parama.pzP, parama.pzR));
          if (k >= parama.pzP) {
            break label2921;
          }
          parama.pzH.setCurrentItem(0);
        }
      }
      for (;;)
      {
        parama.pzH.setGravity(parama.fl);
        parama.pzI = ((WheelView)parama.view.findViewById(a.f.second));
        parama.pzI.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
        parama.pzI.setCurrentItem(j);
        parama.pzI.setGravity(parama.fl);
        parama.pzG.setOnItemSelectedListener(new e.3(parama));
        parama.pzD.setOnItemSelectedListener(new e.2(parama));
        parama.pzE.setOnItemSelectedListener(new e.1(parama));
        parama.b(parama.pzF);
        parama.b(parama.pzG);
        parama.b(parama.pzH);
        parama.b(parama.pzI);
        if (parama.pyK.length == 6) {
          break label3114;
        }
        parama = new IllegalArgumentException("type[] length is not 6");
        AppMethodBeat.o(175354);
        throw parama;
        parama = this.pyC.pyV;
        break;
        parama = this.pyC.pyW;
        break label174;
        parama = this.pyC.pyX;
        break label196;
        if (this.pyC.pyM != null)
        {
          if (this.pyC.pyM.get(1) >= 1900) {
            break label489;
          }
          bc.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
          this.pyC.pyM = null;
          break label489;
        }
        if ((this.pyC.pyN == null) || (this.pyC.pyN.get(1) <= 2100)) {
          break label489;
        }
        bc.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
        this.pyC.pyM = null;
        break label489;
        if (i != parama.startYear) {
          break label570;
        }
        if (j > parama.pzK)
        {
          parama.endYear = i;
          parama.pzL = j;
          parama.pzN = k;
          break label570;
        }
        if ((j != parama.pzK) || (k <= parama.pzM)) {
          break label570;
        }
        parama.endYear = i;
        parama.pzL = j;
        parama.pzN = k;
        break label570;
        label1531:
        if ((localObject1 != null) && (localObject2 == null))
        {
          i = ((Calendar)localObject1).get(1);
          j = ((Calendar)localObject1).get(2) + 1;
          k = ((Calendar)localObject1).get(5);
          if (i < parama.endYear)
          {
            parama.pzK = j;
            parama.pzM = k;
            parama.startYear = i;
            break label570;
          }
          if (i != parama.endYear) {
            break label570;
          }
          if (j < parama.pzL)
          {
            parama.pzK = j;
            parama.pzM = k;
            parama.startYear = i;
            break label570;
          }
          if ((j != parama.pzL) || (k >= parama.pzN)) {
            break label570;
          }
          parama.pzK = j;
          parama.pzM = k;
          parama.startYear = i;
          break label570;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          break label570;
        }
        parama.startYear = ((Calendar)localObject1).get(1);
        parama.endYear = ((Calendar)localObject2).get(1);
        parama.pzK = (((Calendar)localObject1).get(2) + 1);
        parama.pzL = (((Calendar)localObject2).get(2) + 1);
        parama.pzM = ((Calendar)localObject1).get(5);
        parama.pzN = ((Calendar)localObject2).get(5);
        parama.pzO = ((Calendar)localObject1).get(11);
        parama.pzP = ((Calendar)localObject1).get(12);
        parama.pzQ = ((Calendar)localObject2).get(11);
        parama.pzR = ((Calendar)localObject2).get(12);
        break label570;
        label1784:
        if (this.pyC.pyL.getTimeInMillis() <= this.pyC.pyN.getTimeInMillis()) {
          break label645;
        }
        this.pyC.pyL = this.pyC.pyN;
        break label645;
        if (this.pyC.pyM != null)
        {
          this.pyC.pyL = this.pyC.pyM;
          break label645;
        }
        if (this.pyC.pyN == null) {
          break label645;
        }
        this.pyC.pyL = this.pyC.pyN;
        break label645;
        label1879:
        i = this.pyC.pyL.get(1);
        i1 = this.pyC.pyL.get(2);
        n = this.pyC.pyL.get(5);
        m = this.pyC.pyL.get(11);
        k = this.pyC.pyL.get(12);
        j = this.pyC.pyL.get(13);
        break label709;
        if (i == parama.startYear)
        {
          parama.pzE.setAdapter(new com.tencent.mm.picker.a.c(parama.pzK, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
          parama.pzE.setCurrentItem(i1 + 1 - parama.pzK);
          break label888;
        }
        if (i == parama.endYear)
        {
          parama.pzE.setAdapter(new com.tencent.mm.picker.a.c(1, parama.pzL, new com.tencent.mm.picker.a.b(parama.ctx)));
          parama.pzE.setCurrentItem(i1);
          break label888;
        }
        if ((parama.pyg) && (i - 1 == parama.startYear))
        {
          parama.pzE.setAdapter(new com.tencent.mm.picker.a.c(parama.pzK, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
          parama.pzE.setCurrentItem(i1 + 1 - parama.pzK);
          break label888;
        }
        parama.pzE.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
        parama.pzE.setCurrentItem(i1);
        break label888;
        if (parama.pzX.contains(String.valueOf(i1 + 1)))
        {
          if (parama.pzN > 30) {
            parama.pzN = 30;
          }
          parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, parama.pzN));
          break label989;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
        {
          if (parama.pzN > 29) {
            parama.pzN = 29;
          }
          parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, parama.pzN));
          break label989;
        }
        if (parama.pzN > 28) {
          parama.pzN = 28;
        }
        parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, parama.pzN));
        break label989;
        if ((i2 == parama.startYear) && (i1 + 1 == parama.pzK))
        {
          if (parama.pzW.contains(String.valueOf(i1 + 1))) {
            parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, 31));
          }
          for (;;)
          {
            parama.pzF.setCurrentItem(n - parama.pzM);
            break;
            if (parama.pzX.contains(String.valueOf(i1 + 1))) {
              parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, 30));
            } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
              parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, 29));
            } else {
              parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(parama.pzM, 28));
            }
          }
        }
        if ((i2 == parama.endYear) && (i1 + 1 == parama.pzL))
        {
          if (parama.pzW.contains(String.valueOf(i1 + 1)))
          {
            if (parama.pzN > 31) {
              parama.pzN = 31;
            }
            parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, parama.pzN));
          }
          for (;;)
          {
            parama.pzF.setCurrentItem(n - 1);
            break;
            if (parama.pzX.contains(String.valueOf(i1 + 1)))
            {
              if (parama.pzN > 30) {
                parama.pzN = 30;
              }
              parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, parama.pzN));
            }
            else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
            {
              if (parama.pzN > 29) {
                parama.pzN = 29;
              }
              parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, parama.pzN));
            }
            else
            {
              if (parama.pzN > 28) {
                parama.pzN = 28;
              }
              parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, parama.pzN));
            }
          }
        }
        if (parama.pzW.contains(String.valueOf(i1 + 1))) {
          parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
        }
        for (;;)
        {
          parama.pzF.setCurrentItem(n - 1);
          break;
          if (parama.pzX.contains(String.valueOf(i1 + 1))) {
            parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
          } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
            parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
          } else {
            parama.pzF.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
          }
        }
        label2921:
        if (k > parama.pzR)
        {
          parama.pzH.setCurrentItem(parama.pzR);
        }
        else
        {
          parama.pzH.setCurrentItem(k);
          continue;
          if (m == parama.pzO)
          {
            parama.pzH.setAdapter(new com.tencent.mm.picker.a.c(parama.pzP, 59));
            if (k < parama.pzP) {
              parama.pzH.setCurrentItem(0);
            } else {
              parama.pzH.setCurrentItem(k - parama.pzP);
            }
          }
          else if (m == parama.pzQ)
          {
            parama.pzH.setAdapter(new com.tencent.mm.picker.a.c(0, parama.pzR));
            if (k >= parama.pzR) {
              parama.pzH.setCurrentItem(parama.pzR);
            } else {
              parama.pzH.setCurrentItem(k);
            }
          }
          else
          {
            parama.pzH.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
            parama.pzH.setCurrentItem(k);
          }
        }
      }
      e.cs(parama.bTk());
      if ((parama.pyg) && (i == 2))
      {
        parama.pzE.xS(0);
        parama.pzF.xS(0);
        parama.pzE.invalidate();
        parama.pzF.invalidate();
      }
      if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
      {
        parama = this.pzv;
        localObject1 = this.pyC.pyO;
        localObject2 = this.pyC.pyP;
        localObject3 = this.pyC.pyQ;
        localObject4 = this.pyC.pyR;
        localObject5 = this.pyC.pyS;
        String str = this.pyC.pyT;
        if (localObject1 == null) {
          break label3529;
        }
        parama.pzD.setLabel((String)localObject1);
        if (localObject2 == null) {
          break label3552;
        }
        parama.pzE.setLabel((String)localObject2);
        if (localObject3 == null) {
          break label3575;
        }
        parama.pzF.setLabel((String)localObject3);
        label3291:
        if (localObject4 == null) {
          break label3598;
        }
        parama.pzG.setLabel((String)localObject4);
        label3305:
        if (localObject5 == null) {
          break label3621;
        }
        parama.pzH.setLabel((String)localObject5);
        label3319:
        if (str == null) {
          break label3644;
        }
        parama.pzI.setLabel(str);
      }
      for (;;)
      {
        hE(this.pyC.dqR);
        this.pzv.setDividerColor(this.pyC.pyf);
        this.pzv.pzh = this.pyC.pzh;
        parama = this.pzv;
        boolean bool = this.pyC.pyI;
        parama.pzD.setCyclic(bool);
        parama.pzE.setCyclic(bool);
        parama.pzF.setCyclic(bool);
        parama.pzG.setCyclic(bool);
        parama.pzH.setCyclic(bool);
        parama.pzI.setCyclic(bool);
        this.pzv.bbg = this.pyC.bbg;
        parama = this.pzv;
        bool = this.pyC.pxZ;
        parama.pzF.pxZ = bool;
        parama.pzE.pxZ = bool;
        parama.pzD.pxZ = bool;
        parama.pzG.pxZ = bool;
        parama.pzH.pxZ = bool;
        parama.pzI.pxZ = bool;
        AppMethodBeat.o(175354);
        return;
        parama.pzD.setLabel(parama.view.getContext().getString(a.i.pickerview_year));
        break;
        label3552:
        parama.pzE.setLabel(parama.view.getContext().getString(a.i.pickerview_month));
        break label3277;
        label3575:
        parama.pzF.setLabel(parama.view.getContext().getString(a.i.pickerview_day));
        break label3291;
        parama.pzG.setLabel(parama.view.getContext().getString(a.i.pickerview_hours));
        break label3305;
        parama.pzH.setLabel(parama.view.getContext().getString(a.i.pickerview_minutes));
        break label3319;
        parama.pzI.setLabel(parama.view.getContext().getString(a.i.pickerview_seconds));
      }
    }
  }
  
  public final boolean bTd()
  {
    return this.pyC.pzg;
  }
  
  public final void bTe()
  {
    AppMethodBeat.i(175356);
    if (this.pyC.pyF != null) {
      try
      {
        Date localDate = e.dateFormat.parse(this.pzv.getTime());
        this.pyC.pyF.a(localDate);
        AppMethodBeat.o(175356);
        return;
      }
      catch (ParseException localParseException)
      {
        bc.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(175356);
  }
  
  public final View bTg()
  {
    AppMethodBeat.i(175357);
    if (this.pzv.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(a.g.mm_pickerview_time, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.timepicker);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.pzv.view = localLinearLayout;
    }
    View localView = this.pzv.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final List<WheelView> bTh()
  {
    AppMethodBeat.i(231649);
    List localList = this.pzv.bTk();
    AppMethodBeat.o(231649);
    return localList;
  }
  
  public final void eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.pzv;
    locale.pzF.setPadding(0, paramInt1, 0, paramInt2);
    locale.pzG.setPadding(0, paramInt1, 0, paramInt2);
    locale.pzH.setPadding(0, paramInt1, 0, paramInt2);
    locale.pzD.setPadding(0, paramInt1, 0, paramInt2);
    locale.pzE.setPadding(0, paramInt1, 0, paramInt2);
    locale.pzI.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (((String)paramView.getTag()).equals("submit")) {
      bTe();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(231643);
    this.pzv.setDividerColor(paramInt);
    AppMethodBeat.o(231643);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.pzv != null)
    {
      e locale = this.pzv;
      locale.pzF.setDividerHeight(paramFloat);
      locale.pzG.setDividerHeight(paramFloat);
      locale.pzH.setDividerHeight(paramFloat);
      locale.pzD.setDividerHeight(paramFloat);
      locale.pzE.setDividerHeight(paramFloat);
      locale.pzI.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */