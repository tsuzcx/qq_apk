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
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.ui.av;
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
  public e mCN;
  public boolean mCO;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.mCO = false;
    this.mCN = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.mBU = parama;
    Object localObject5 = parama.context;
    buT();
    buQ();
    buR();
    LayoutInflater.from((Context)localObject5).inflate(a.g.mm_pickerview_time, this.mCB);
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
    if (TextUtils.isEmpty(this.mBU.mCn))
    {
      parama = ((Context)localObject5).getResources().getString(a.i.pickerview_submit);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.mBU.mCo)) {
        break label1334;
      }
      parama = ((Context)localObject5).getResources().getString(a.i.pickerview_cancel);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.mBU.mCp)) {
        break label1345;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.mBU.mCq);
      ((Button)localObject4).setTextColor(this.mBU.mCr);
      ((TextView)localObject1).setTextColor(this.mBU.mCs);
      ((RelativeLayout)localObject2).setBackgroundColor(this.mBU.mCu);
      ((Button)localObject3).setTextSize(this.mBU.mCv);
      ((Button)localObject4).setTextSize(this.mBU.mCv);
      ((TextView)localObject1).setTextSize(this.mBU.mCw);
      parama = this.mCN;
      localObject1 = this.mBU.mCc;
      i = this.mBU.mCm;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.mCc = ((boolean[])localObject1);
      parama.ek = i;
      if (this.mBU.mBY != null) {
        this.mCN.mDm = new com.tencent.mm.picker.d.a()
        {
          public final void buO()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.dateFormat.parse(c.b(c.this).getTime());
              c.this.mBU.mBY.buP();
              AppMethodBeat.o(175352);
              return;
            }
            catch (ParseException localParseException)
            {
              av.printErrStackTrace(c.c(c.this), localParseException, "", new Object[0]);
              AppMethodBeat.o(175352);
            }
          }
        };
      }
      if ((this.mBU.startYear != 0) && (this.mBU.endYear != 0) && (this.mBU.startYear <= this.mBU.endYear))
      {
        this.mCN.startYear = this.mBU.startYear;
        this.mCN.endYear = this.mBU.endYear;
      }
      if ((this.mBU.mCe == null) || (this.mBU.mCf == null)) {
        break label1356;
      }
      if (this.mBU.mCe.getTimeInMillis() > this.mBU.mCf.getTimeInMillis())
      {
        av.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.mBU.mCe = null;
      }
      parama = this.mCN;
      localObject1 = this.mBU.mCe;
      localObject2 = this.mBU.mCf;
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
      parama.mDe = j;
      parama.mDg = k;
      if (!this.mCO)
      {
        if ((this.mBU.mCe == null) || (this.mBU.mCf == null)) {
          break label1825;
        }
        if ((this.mBU.mCd != null) && (this.mBU.mCd.getTimeInMillis() >= this.mBU.mCe.getTimeInMillis())) {
          break label1784;
        }
        this.mBU.mCd = this.mBU.mCe;
      }
      if (this.mBU.mCd != null) {
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
      parama = this.mCN;
      parama.mDl = i;
      parama.mCV = ((WheelView)parama.view.findViewById(a.f.year));
      parama.mCW = ((WheelView)parama.view.findViewById(a.f.month));
      parama.mCX = ((WheelView)parama.view.findViewById(a.f.day));
      parama.mDc = new com.tencent.mm.picker.a.d(parama.startYear, parama.endYear, parama.ctx);
      parama.mCV.setAdapter(parama.mDc);
      parama.mCV.setCurrentItem(i - parama.startYear);
      parama.mCV.setGravity(parama.ek);
      if (parama.startYear != parama.endYear) {
        break label1961;
      }
      parama.mCW.setAdapter(new com.tencent.mm.picker.a.c(parama.mDd, parama.mDe, new com.tencent.mm.picker.a.b(parama.ctx)));
      parama.mCW.setCurrentItem(i1 + 1 - parama.mDd);
      label888:
      parama.mCW.setGravity(parama.ek);
      if (!parama.mBy) {
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
      if ((parama.startYear == parama.endYear) && (parama.mDd == parama.mDe)) {
        if (parama.mDp.contains(String.valueOf(i1 + 1)))
        {
          if (parama.mDg > 31) {
            parama.mDg = 31;
          }
          parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, parama.mDg));
          label989:
          parama.mCX.setCurrentItem(n - parama.mDf);
          parama.mCX.setGravity(parama.ek);
          parama.mCY = ((WheelView)parama.view.findViewById(a.f.hour));
          parama.mCY.setAdapter(new com.tencent.mm.picker.a.c(parama.mDh, parama.mDj));
          parama.mCY.setCurrentItem(m - parama.mDh);
          parama.mCY.setGravity(parama.ek);
          parama.mCZ = ((WheelView)parama.view.findViewById(a.f.min));
          if ((m != parama.mDh) || (parama.mDh != parama.mDj)) {
            break label2956;
          }
          parama.mCZ.setAdapter(new com.tencent.mm.picker.a.c(parama.mDi, parama.mDk));
          if (k >= parama.mDi) {
            break label2921;
          }
          parama.mCZ.setCurrentItem(0);
        }
      }
      for (;;)
      {
        parama.mCZ.setGravity(parama.ek);
        parama.mDa = ((WheelView)parama.view.findViewById(a.f.second));
        parama.mDa.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
        parama.mDa.setCurrentItem(j);
        parama.mDa.setGravity(parama.ek);
        parama.mCY.setOnItemSelectedListener(new e.3(parama));
        parama.mCV.setOnItemSelectedListener(new e.2(parama));
        parama.mCW.setOnItemSelectedListener(new e.1(parama));
        parama.b(parama.mCX);
        parama.b(parama.mCY);
        parama.b(parama.mCZ);
        parama.b(parama.mDa);
        if (parama.mCc.length == 6) {
          break label3114;
        }
        parama = new IllegalArgumentException("type[] length is not 6");
        AppMethodBeat.o(175354);
        throw parama;
        parama = this.mBU.mCn;
        break;
        parama = this.mBU.mCo;
        break label174;
        parama = this.mBU.mCp;
        break label196;
        if (this.mBU.mCe != null)
        {
          if (this.mBU.mCe.get(1) >= 1900) {
            break label489;
          }
          av.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
          this.mBU.mCe = null;
          break label489;
        }
        if ((this.mBU.mCf == null) || (this.mBU.mCf.get(1) <= 2100)) {
          break label489;
        }
        av.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
        this.mBU.mCe = null;
        break label489;
        if (i != parama.startYear) {
          break label570;
        }
        if (j > parama.mDd)
        {
          parama.endYear = i;
          parama.mDe = j;
          parama.mDg = k;
          break label570;
        }
        if ((j != parama.mDd) || (k <= parama.mDf)) {
          break label570;
        }
        parama.endYear = i;
        parama.mDe = j;
        parama.mDg = k;
        break label570;
        label1531:
        if ((localObject1 != null) && (localObject2 == null))
        {
          i = ((Calendar)localObject1).get(1);
          j = ((Calendar)localObject1).get(2) + 1;
          k = ((Calendar)localObject1).get(5);
          if (i < parama.endYear)
          {
            parama.mDd = j;
            parama.mDf = k;
            parama.startYear = i;
            break label570;
          }
          if (i != parama.endYear) {
            break label570;
          }
          if (j < parama.mDe)
          {
            parama.mDd = j;
            parama.mDf = k;
            parama.startYear = i;
            break label570;
          }
          if ((j != parama.mDe) || (k >= parama.mDg)) {
            break label570;
          }
          parama.mDd = j;
          parama.mDf = k;
          parama.startYear = i;
          break label570;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          break label570;
        }
        parama.startYear = ((Calendar)localObject1).get(1);
        parama.endYear = ((Calendar)localObject2).get(1);
        parama.mDd = (((Calendar)localObject1).get(2) + 1);
        parama.mDe = (((Calendar)localObject2).get(2) + 1);
        parama.mDf = ((Calendar)localObject1).get(5);
        parama.mDg = ((Calendar)localObject2).get(5);
        parama.mDh = ((Calendar)localObject1).get(11);
        parama.mDi = ((Calendar)localObject1).get(12);
        parama.mDj = ((Calendar)localObject2).get(11);
        parama.mDk = ((Calendar)localObject2).get(12);
        break label570;
        label1784:
        if (this.mBU.mCd.getTimeInMillis() <= this.mBU.mCf.getTimeInMillis()) {
          break label645;
        }
        this.mBU.mCd = this.mBU.mCf;
        break label645;
        if (this.mBU.mCe != null)
        {
          this.mBU.mCd = this.mBU.mCe;
          break label645;
        }
        if (this.mBU.mCf == null) {
          break label645;
        }
        this.mBU.mCd = this.mBU.mCf;
        break label645;
        label1879:
        i = this.mBU.mCd.get(1);
        i1 = this.mBU.mCd.get(2);
        n = this.mBU.mCd.get(5);
        m = this.mBU.mCd.get(11);
        k = this.mBU.mCd.get(12);
        j = this.mBU.mCd.get(13);
        break label709;
        if (i == parama.startYear)
        {
          parama.mCW.setAdapter(new com.tencent.mm.picker.a.c(parama.mDd, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
          parama.mCW.setCurrentItem(i1 + 1 - parama.mDd);
          break label888;
        }
        if (i == parama.endYear)
        {
          parama.mCW.setAdapter(new com.tencent.mm.picker.a.c(1, parama.mDe, new com.tencent.mm.picker.a.b(parama.ctx)));
          parama.mCW.setCurrentItem(i1);
          break label888;
        }
        if ((parama.mBy) && (i - 1 == parama.startYear))
        {
          parama.mCW.setAdapter(new com.tencent.mm.picker.a.c(parama.mDd, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
          parama.mCW.setCurrentItem(i1 + 1 - parama.mDd);
          break label888;
        }
        parama.mCW.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
        parama.mCW.setCurrentItem(i1);
        break label888;
        if (parama.mDq.contains(String.valueOf(i1 + 1)))
        {
          if (parama.mDg > 30) {
            parama.mDg = 30;
          }
          parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, parama.mDg));
          break label989;
        }
        if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
        {
          if (parama.mDg > 29) {
            parama.mDg = 29;
          }
          parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, parama.mDg));
          break label989;
        }
        if (parama.mDg > 28) {
          parama.mDg = 28;
        }
        parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, parama.mDg));
        break label989;
        if ((i2 == parama.startYear) && (i1 + 1 == parama.mDd))
        {
          if (parama.mDp.contains(String.valueOf(i1 + 1))) {
            parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, 31));
          }
          for (;;)
          {
            parama.mCX.setCurrentItem(n - parama.mDf);
            break;
            if (parama.mDq.contains(String.valueOf(i1 + 1))) {
              parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, 30));
            } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
              parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, 29));
            } else {
              parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(parama.mDf, 28));
            }
          }
        }
        if ((i2 == parama.endYear) && (i1 + 1 == parama.mDe))
        {
          if (parama.mDp.contains(String.valueOf(i1 + 1)))
          {
            if (parama.mDg > 31) {
              parama.mDg = 31;
            }
            parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, parama.mDg));
          }
          for (;;)
          {
            parama.mCX.setCurrentItem(n - 1);
            break;
            if (parama.mDq.contains(String.valueOf(i1 + 1)))
            {
              if (parama.mDg > 30) {
                parama.mDg = 30;
              }
              parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, parama.mDg));
            }
            else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0))
            {
              if (parama.mDg > 29) {
                parama.mDg = 29;
              }
              parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, parama.mDg));
            }
            else
            {
              if (parama.mDg > 28) {
                parama.mDg = 28;
              }
              parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, parama.mDg));
            }
          }
        }
        if (parama.mDp.contains(String.valueOf(i1 + 1))) {
          parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
        }
        for (;;)
        {
          parama.mCX.setCurrentItem(n - 1);
          break;
          if (parama.mDq.contains(String.valueOf(i1 + 1))) {
            parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
          } else if (((i2 % 4 == 0) && (i2 % 100 != 0)) || (i2 % 400 == 0)) {
            parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
          } else {
            parama.mCX.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
          }
        }
        label2921:
        if (k > parama.mDk)
        {
          parama.mCZ.setCurrentItem(parama.mDk);
        }
        else
        {
          parama.mCZ.setCurrentItem(k);
          continue;
          if (m == parama.mDh)
          {
            parama.mCZ.setAdapter(new com.tencent.mm.picker.a.c(parama.mDi, 59));
            if (k < parama.mDi) {
              parama.mCZ.setCurrentItem(0);
            } else {
              parama.mCZ.setCurrentItem(k - parama.mDi);
            }
          }
          else if (m == parama.mDj)
          {
            parama.mCZ.setAdapter(new com.tencent.mm.picker.a.c(0, parama.mDk));
            if (k >= parama.mDk) {
              parama.mCZ.setCurrentItem(parama.mDk);
            } else {
              parama.mCZ.setCurrentItem(k);
            }
          }
          else
          {
            parama.mCZ.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
            parama.mCZ.setCurrentItem(k);
          }
        }
      }
      e.aN(parama.bvb());
      if ((parama.mBy) && (i == 2))
      {
        parama.mCW.xN(0);
        parama.mCX.xN(0);
        parama.mCW.invalidate();
        parama.mCX.invalidate();
      }
      if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
      {
        parama = this.mCN;
        localObject1 = this.mBU.mCg;
        localObject2 = this.mBU.mCh;
        localObject3 = this.mBU.mCi;
        localObject4 = this.mBU.mCj;
        localObject5 = this.mBU.mCk;
        String str = this.mBU.mCl;
        if (localObject1 == null) {
          break label3529;
        }
        parama.mCV.setLabel((String)localObject1);
        if (localObject2 == null) {
          break label3552;
        }
        parama.mCW.setLabel((String)localObject2);
        if (localObject3 == null) {
          break label3575;
        }
        parama.mCX.setLabel((String)localObject3);
        label3291:
        if (localObject4 == null) {
          break label3598;
        }
        parama.mCY.setLabel((String)localObject4);
        label3305:
        if (localObject5 == null) {
          break label3621;
        }
        parama.mCZ.setLabel((String)localObject5);
        label3319:
        if (str == null) {
          break label3644;
        }
        parama.mDa.setLabel(str);
      }
      for (;;)
      {
        gP(this.mBU.bxO);
        this.mCN.setDividerColor(this.mBU.mBx);
        this.mCN.mCA = this.mBU.mCA;
        parama = this.mCN;
        boolean bool = this.mBU.mCa;
        parama.mCV.setCyclic(bool);
        parama.mCW.setCyclic(bool);
        parama.mCX.setCyclic(bool);
        parama.mCY.setCyclic(bool);
        parama.mCZ.setCyclic(bool);
        parama.mDa.setCyclic(bool);
        this.mCN.mCy = this.mBU.mCy;
        parama = this.mCN;
        bool = this.mBU.mBq;
        parama.mCX.mBq = bool;
        parama.mCW.mBq = bool;
        parama.mCV.mBq = bool;
        parama.mCY.mBq = bool;
        parama.mCZ.mBq = bool;
        parama.mDa.mBq = bool;
        AppMethodBeat.o(175354);
        return;
        parama.mCV.setLabel(parama.view.getContext().getString(a.i.pickerview_year));
        break;
        label3552:
        parama.mCW.setLabel(parama.view.getContext().getString(a.i.pickerview_month));
        break label3277;
        label3575:
        parama.mCX.setLabel(parama.view.getContext().getString(a.i.pickerview_day));
        break label3291;
        parama.mCY.setLabel(parama.view.getContext().getString(a.i.pickerview_hours));
        break label3305;
        parama.mCZ.setLabel(parama.view.getContext().getString(a.i.pickerview_minutes));
        break label3319;
        parama.mDa.setLabel(parama.view.getContext().getString(a.i.pickerview_seconds));
      }
    }
  }
  
  public final boolean buU()
  {
    return this.mBU.mCz;
  }
  
  public final void buV()
  {
    AppMethodBeat.i(175356);
    if (this.mBU.mBX != null) {
      try
      {
        Date localDate = e.dateFormat.parse(this.mCN.getTime());
        this.mBU.mBX.a(localDate);
        AppMethodBeat.o(175356);
        return;
      }
      catch (ParseException localParseException)
      {
        av.printErrStackTrace(this.TAG, localParseException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(175356);
  }
  
  public final View buX()
  {
    AppMethodBeat.i(175357);
    if (this.mCN.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(a.g.mm_pickerview_time, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.timepicker);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.mCN.view = localLinearLayout;
    }
    View localView = this.mCN.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final List<WheelView> buY()
  {
    AppMethodBeat.i(252599);
    List localList = this.mCN.bvb();
    AppMethodBeat.o(252599);
    return localList;
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.mCN;
    locale.mCX.setPadding(0, paramInt1, 0, paramInt2);
    locale.mCY.setPadding(0, paramInt1, 0, paramInt2);
    locale.mCZ.setPadding(0, paramInt1, 0, paramInt2);
    locale.mCV.setPadding(0, paramInt1, 0, paramInt2);
    locale.mCW.setPadding(0, paramInt1, 0, paramInt2);
    locale.mDa.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (((String)paramView.getTag()).equals("submit")) {
      buV();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(252597);
    this.mCN.setDividerColor(paramInt);
    AppMethodBeat.o(252597);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.mCN != null)
    {
      e locale = this.mCN;
      locale.mCX.setDividerHeight(paramFloat);
      locale.mCY.setDividerHeight(paramFloat);
      locale.mCZ.setDividerHeight(paramFloat);
      locale.mCV.setDividerHeight(paramFloat);
      locale.mCW.setDividerHeight(paramFloat);
      locale.mDa.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */