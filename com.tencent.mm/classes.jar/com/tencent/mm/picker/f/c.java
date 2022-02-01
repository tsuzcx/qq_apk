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
import com.tencent.mm.picker.a.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.stubs.logger.Log;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class c
  extends a
  implements View.OnClickListener
{
  private String TAG;
  private Context context;
  public e hST;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.hST = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final boolean aGd()
  {
    return this.hSa.hSF;
  }
  
  public final void aGe()
  {
    AppMethodBeat.i(175356);
    if (this.hSa.hSc != null) {
      try
      {
        Date localDate = e.hTa.parse(this.hST.aGk());
        this.hSa.hSc.a(localDate);
        AppMethodBeat.o(175356);
        return;
      }
      catch (ParseException localParseException)
      {
        Log.printStack(6, this.TAG, localParseException);
      }
    }
    AppMethodBeat.o(175356);
  }
  
  public final View aGg()
  {
    AppMethodBeat.i(175357);
    if (this.hST.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495093, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.hST.view = localLinearLayout;
    }
    View localView = this.hST.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.hSa = parama;
    Object localObject5 = parama.context;
    aGc();
    aFZ();
    aGa();
    LayoutInflater.from((Context)localObject5).inflate(2131495093, this.hSH);
    Object localObject1 = (TextView)findViewById(2131306103);
    Object localObject2 = (RelativeLayout)findViewById(2131304274);
    Object localObject3 = (Button)findViewById(2131297582);
    Object localObject4 = (Button)findViewById(2131297577);
    ((Button)localObject3).setTag("submit");
    ((Button)localObject4).setTag("cancel");
    ((Button)localObject3).setOnClickListener(this);
    ((Button)localObject4).setOnClickListener(this);
    label167:
    label189:
    int i;
    label479:
    int j;
    int k;
    label560:
    label628:
    int i1;
    int n;
    int m;
    if (TextUtils.isEmpty(this.hSa.hSt))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.hSa.hSu)) {
        break label1294;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.hSa.hSv)) {
        break label1305;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.hSa.hSw);
      ((Button)localObject4).setTextColor(this.hSa.hSx);
      ((TextView)localObject1).setTextColor(this.hSa.hSy);
      ((RelativeLayout)localObject2).setBackgroundColor(this.hSa.hSA);
      ((Button)localObject3).setTextSize(this.hSa.hSB);
      ((Button)localObject4).setTextSize(this.hSa.hSB);
      ((TextView)localObject1).setTextSize(this.hSa.hSC);
      parama = this.hST;
      localObject1 = this.hSa.hSh;
      i = this.hSa.hSs;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.hSh = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.hSa.hSd != null) {
        this.hST.hTq = new com.tencent.mm.picker.d.a()
        {
          public final void aFY()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.hTa.parse(c.b(c.this).aGk());
              AppMethodBeat.o(175352);
              return;
            }
            catch (ParseException localParseException)
            {
              Log.printStack(6, c.c(c.this), localParseException);
              AppMethodBeat.o(175352);
            }
          }
        };
      }
      if ((this.hSa.startYear != 0) && (this.hSa.endYear != 0) && (this.hSa.startYear <= this.hSa.endYear))
      {
        this.hST.startYear = this.hSa.startYear;
        this.hST.endYear = this.hSa.endYear;
      }
      if ((this.hSa.hSj == null) || (this.hSa.hSk == null)) {
        break label1316;
      }
      if (this.hSa.hSj.getTimeInMillis() > this.hSa.hSk.getTimeInMillis())
      {
        Log.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null");
        this.hSa.hSj = null;
      }
      parama = this.hST;
      localObject1 = this.hSa.hSj;
      localObject2 = this.hSa.hSk;
      if ((localObject1 != null) || (localObject2 == null)) {
        break label1483;
      }
      i = ((Calendar)localObject2).get(1);
      j = ((Calendar)localObject2).get(2) + 1;
      k = ((Calendar)localObject2).get(5);
      if (i <= parama.startYear) {
        break label1412;
      }
      parama.endYear = i;
      parama.hTi = j;
      parama.hTk = k;
      if ((this.hSa.hSj == null) || (this.hSa.hSk == null)) {
        break label1777;
      }
      if ((this.hSa.hSi != null) && (this.hSa.hSi.getTimeInMillis() >= this.hSa.hSj.getTimeInMillis())) {
        break label1736;
      }
      this.hSa.hSi = this.hSa.hSj;
      if (this.hSa.hSi != null) {
        break label1831;
      }
      parama = Calendar.getInstance();
      parama.setTimeInMillis(System.currentTimeMillis());
      i1 = parama.get(1);
      n = parama.get(2);
      m = parama.get(5);
      k = parama.get(11);
      j = parama.get(12);
      i = parama.get(13);
      label692:
      parama = this.hST;
      parama.hTp = i1;
      parama.hTb = ((WheelView)parama.view.findViewById(2131307138));
      parama.hTb.setAdapter(new com.tencent.mm.picker.a.c(parama.startYear, parama.endYear));
      parama.hTb.setCurrentItem(i1 - parama.startYear);
      parama.hTb.setGravity(parama.gravity);
      parama.hTc = ((WheelView)parama.view.findViewById(2131302450));
      if (parama.startYear != parama.endYear) {
        break label1913;
      }
      parama.hTc.setAdapter(new com.tencent.mm.picker.a.c(parama.hTh, parama.hTi, new b(parama.ctx)));
      parama.hTc.setCurrentItem(n + 1 - parama.hTh);
      label844:
      parama.hTc.setGravity(parama.gravity);
      parama.hTd = ((WheelView)parama.view.findViewById(2131298935));
      if ((parama.startYear != parama.endYear) || (parama.hTh != parama.hTi)) {
        break label2226;
      }
      if (!parama.hTt.contains(String.valueOf(n + 1))) {
        break label2063;
      }
      if (parama.hTk > 31) {
        parama.hTk = 31;
      }
      parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, parama.hTk));
      label950:
      parama.hTd.setCurrentItem(m - parama.hTj);
      parama.hTd.setGravity(parama.gravity);
      parama.hTe = ((WheelView)parama.view.findViewById(2131300765));
      parama.hTe.setAdapter(new com.tencent.mm.picker.a.c(parama.hTl, parama.hTn));
      parama.hTe.setCurrentItem(k - parama.hTl);
      parama.hTe.setGravity(parama.gravity);
      parama.hTf = ((WheelView)parama.view.findViewById(2131302275));
      if ((k != parama.hTl) || (parama.hTl != parama.hTn)) {
        break label2841;
      }
      parama.hTf.setAdapter(new com.tencent.mm.picker.a.c(parama.hTm, parama.hTo));
      if (j >= parama.hTm) {
        break label2808;
      }
      parama.hTf.setCurrentItem(0);
    }
    label1294:
    label2063:
    label2841:
    for (;;)
    {
      parama.hTf.setGravity(parama.gravity);
      parama.hTg = ((WheelView)parama.view.findViewById(2131304457));
      parama.hTg.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
      parama.hTg.setCurrentItem(i);
      parama.hTg.setGravity(parama.gravity);
      parama.hTe.setOnItemSelectedListener(new e.3(parama));
      parama.hTb.setOnItemSelectedListener(new e.2(parama));
      parama.hTc.setOnItemSelectedListener(new e.1(parama));
      parama.b(parama.hTd);
      parama.b(parama.hTe);
      parama.b(parama.hTf);
      parama.b(parama.hTg);
      if (parama.hSh.length == 6) {
        break label2994;
      }
      parama = new IllegalArgumentException("type[] length is not 6");
      AppMethodBeat.o(175354);
      throw parama;
      parama = this.hSa.hSt;
      break;
      parama = this.hSa.hSu;
      break label167;
      label1305:
      parama = this.hSa.hSv;
      break label189;
      label1316:
      if (this.hSa.hSj != null)
      {
        if (this.hSa.hSj.get(1) >= 1900) {
          break label479;
        }
        Log.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null");
        this.hSa.hSj = null;
        break label479;
      }
      if ((this.hSa.hSk == null) || (this.hSa.hSk.get(1) <= 2100)) {
        break label479;
      }
      Log.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null");
      this.hSa.hSj = null;
      break label479;
      if (i != parama.startYear) {
        break label560;
      }
      if (j > parama.hTh)
      {
        parama.endYear = i;
        parama.hTi = j;
        parama.hTk = k;
        break label560;
      }
      if ((j != parama.hTh) || (k <= parama.hTj)) {
        break label560;
      }
      parama.endYear = i;
      parama.hTi = j;
      parama.hTk = k;
      break label560;
      label1483:
      if ((localObject1 != null) && (localObject2 == null))
      {
        i = ((Calendar)localObject1).get(1);
        j = ((Calendar)localObject1).get(2) + 1;
        k = ((Calendar)localObject1).get(5);
        if (i < parama.endYear)
        {
          parama.hTh = j;
          parama.hTj = k;
          parama.startYear = i;
          break label560;
        }
        if (i != parama.endYear) {
          break label560;
        }
        if (j < parama.hTi)
        {
          parama.hTh = j;
          parama.hTj = k;
          parama.startYear = i;
          break label560;
        }
        if ((j != parama.hTi) || (k >= parama.hTk)) {
          break label560;
        }
        parama.hTh = j;
        parama.hTj = k;
        parama.startYear = i;
        break label560;
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        break label560;
      }
      parama.startYear = ((Calendar)localObject1).get(1);
      parama.endYear = ((Calendar)localObject2).get(1);
      parama.hTh = (((Calendar)localObject1).get(2) + 1);
      parama.hTi = (((Calendar)localObject2).get(2) + 1);
      parama.hTj = ((Calendar)localObject1).get(5);
      parama.hTk = ((Calendar)localObject2).get(5);
      parama.hTl = ((Calendar)localObject1).get(11);
      parama.hTm = ((Calendar)localObject1).get(12);
      parama.hTn = ((Calendar)localObject2).get(11);
      parama.hTo = ((Calendar)localObject2).get(12);
      break label560;
      label1736:
      if (this.hSa.hSi.getTimeInMillis() <= this.hSa.hSk.getTimeInMillis()) {
        break label628;
      }
      this.hSa.hSi = this.hSa.hSk;
      break label628;
      label1777:
      if (this.hSa.hSj != null)
      {
        this.hSa.hSi = this.hSa.hSj;
        break label628;
      }
      if (this.hSa.hSk == null) {
        break label628;
      }
      this.hSa.hSi = this.hSa.hSk;
      break label628;
      label1831:
      i1 = this.hSa.hSi.get(1);
      n = this.hSa.hSi.get(2);
      m = this.hSa.hSi.get(5);
      k = this.hSa.hSi.get(11);
      j = this.hSa.hSi.get(12);
      i = this.hSa.hSi.get(13);
      break label692;
      label1913:
      if (i1 == parama.startYear)
      {
        parama.hTc.setAdapter(new com.tencent.mm.picker.a.c(parama.hTh, 12, new b(parama.ctx)));
        parama.hTc.setCurrentItem(n + 1 - parama.hTh);
        break label844;
      }
      if (i1 == parama.endYear)
      {
        parama.hTc.setAdapter(new com.tencent.mm.picker.a.c(1, parama.hTi, new b(parama.ctx)));
        parama.hTc.setCurrentItem(n);
        break label844;
      }
      parama.hTc.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new b(parama.ctx)));
      parama.hTc.setCurrentItem(n);
      break label844;
      if (parama.hTu.contains(String.valueOf(n + 1)))
      {
        if (parama.hTk > 30) {
          parama.hTk = 30;
        }
        parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, parama.hTk));
        break label950;
      }
      if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (parama.hTk > 29) {
          parama.hTk = 29;
        }
        parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, parama.hTk));
        break label950;
      }
      if (parama.hTk > 28) {
        parama.hTk = 28;
      }
      parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, parama.hTk));
      break label950;
      label2226:
      if ((i1 == parama.startYear) && (n + 1 == parama.hTh))
      {
        if (parama.hTt.contains(String.valueOf(n + 1))) {
          parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, 31));
        }
        for (;;)
        {
          parama.hTd.setCurrentItem(m - parama.hTj);
          break;
          if (parama.hTu.contains(String.valueOf(n + 1))) {
            parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, 30));
          } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
            parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, 29));
          } else {
            parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(parama.hTj, 28));
          }
        }
      }
      if ((i1 == parama.endYear) && (n + 1 == parama.hTi))
      {
        if (parama.hTt.contains(String.valueOf(n + 1)))
        {
          if (parama.hTk > 31) {
            parama.hTk = 31;
          }
          parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, parama.hTk));
        }
        for (;;)
        {
          parama.hTd.setCurrentItem(m - 1);
          break;
          if (parama.hTu.contains(String.valueOf(n + 1)))
          {
            if (parama.hTk > 30) {
              parama.hTk = 30;
            }
            parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, parama.hTk));
          }
          else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
          {
            if (parama.hTk > 29) {
              parama.hTk = 29;
            }
            parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, parama.hTk));
          }
          else
          {
            if (parama.hTk > 28) {
              parama.hTk = 28;
            }
            parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, parama.hTk));
          }
        }
      }
      if (parama.hTt.contains(String.valueOf(n + 1))) {
        parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
      }
      for (;;)
      {
        parama.hTd.setCurrentItem(m - 1);
        break;
        if (parama.hTu.contains(String.valueOf(n + 1))) {
          parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
        } else {
          parama.hTd.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
        }
      }
      label2808:
      if (j > parama.hTo)
      {
        parama.hTf.setCurrentItem(parama.hTo);
      }
      else
      {
        parama.hTf.setCurrentItem(j);
        continue;
        if (k == parama.hTl)
        {
          parama.hTf.setAdapter(new com.tencent.mm.picker.a.c(parama.hTm, 59));
          if (j < parama.hTm) {
            parama.hTf.setCurrentItem(0);
          } else {
            parama.hTf.setCurrentItem(j - parama.hTm);
          }
        }
        else if (k == parama.hTn)
        {
          parama.hTf.setAdapter(new com.tencent.mm.picker.a.c(0, parama.hTo));
          if (j >= parama.hTo) {
            parama.hTf.setCurrentItem(parama.hTo);
          } else {
            parama.hTf.setCurrentItem(j);
          }
        }
        else
        {
          parama.hTf.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
          parama.hTf.setCurrentItem(j);
        }
      }
    }
    label1412:
    label2994:
    e.aJ(parama.aGj());
    if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      parama = this.hST;
      localObject1 = this.hSa.hSl;
      localObject2 = this.hSa.hSm;
      localObject3 = this.hSa.hSn;
      localObject4 = this.hSa.hSo;
      localObject5 = this.hSa.hSp;
      String str = this.hSa.hSq;
      if (localObject1 == null) {
        break label3365;
      }
      parama.hTb.setLabel((String)localObject1);
      if (localObject2 == null) {
        break label3388;
      }
      parama.hTc.setLabel((String)localObject2);
      label3113:
      if (localObject3 == null) {
        break label3411;
      }
      parama.hTd.setLabel((String)localObject3);
      label3127:
      if (localObject4 == null) {
        break label3434;
      }
      parama.hTe.setLabel((String)localObject4);
      label3141:
      if (localObject5 == null) {
        break label3457;
      }
      parama.hTf.setLabel((String)localObject5);
      label3155:
      if (str == null) {
        break label3480;
      }
      parama.hTg.setLabel(str);
    }
    for (;;)
    {
      eM(this.hSa.lA);
      this.hST.setDividerColor(this.hSa.hRF);
      this.hST.hSG = this.hSa.hSG;
      parama = this.hST;
      boolean bool = this.hSa.hSf;
      parama.hTb.setCyclic(bool);
      parama.hTc.setCyclic(bool);
      parama.hTd.setCyclic(bool);
      parama.hTe.setCyclic(bool);
      parama.hTf.setCyclic(bool);
      parama.hTg.setCyclic(bool);
      this.hST.hSE = this.hSa.hSE;
      parama = this.hST;
      bool = this.hSa.hRy;
      parama.hTd.hRy = bool;
      parama.hTc.hRy = bool;
      parama.hTb.hRy = bool;
      parama.hTe.hRy = bool;
      parama.hTf.hRy = bool;
      parama.hTg.hRy = bool;
      AppMethodBeat.o(175354);
      return;
      label3365:
      parama.hTb.setLabel(parama.view.getContext().getString(2131761931));
      break;
      label3388:
      parama.hTc.setLabel(parama.view.getContext().getString(2131761928));
      break label3113;
      label3411:
      parama.hTd.setLabel(parama.view.getContext().getString(2131761925));
      break label3127;
      label3434:
      parama.hTe.setLabel(parama.view.getContext().getString(2131761926));
      break label3141;
      label3457:
      parama.hTf.setLabel(parama.view.getContext().getString(2131761927));
      break label3155;
      label3480:
      parama.hTg.setLabel(parama.view.getContext().getString(2131761929));
    }
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.hST;
    locale.hTd.setPadding(0, paramInt1, 0, paramInt2);
    locale.hTe.setPadding(0, paramInt1, 0, paramInt2);
    locale.hTf.setPadding(0, paramInt1, 0, paramInt2);
    locale.hTb.setPadding(0, paramInt1, 0, paramInt2);
    locale.hTc.setPadding(0, paramInt1, 0, paramInt2);
    locale.hTg.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    if (((String)paramView.getTag()).equals("submit")) {
      aGe();
    }
    dismiss();
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.hST != null)
    {
      e locale = this.hST;
      locale.hTd.setDividerHeight(paramFloat);
      locale.hTe.setDividerHeight(paramFloat);
      locale.hTf.setDividerHeight(paramFloat);
      locale.hTb.setDividerHeight(paramFloat);
      locale.hTc.setDividerHeight(paramFloat);
      locale.hTg.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */