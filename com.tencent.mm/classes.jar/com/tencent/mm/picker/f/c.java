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
  public e iOU;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.iOU = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final boolean aQA()
  {
    return this.iOb.iOG;
  }
  
  public final void aQB()
  {
    AppMethodBeat.i(175356);
    if (this.iOb.iOd != null) {
      try
      {
        Date localDate = e.iPb.parse(this.iOU.aQH());
        this.iOb.iOd.a(localDate);
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
  
  public final View aQD()
  {
    AppMethodBeat.i(175357);
    if (this.iOU.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495093, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.iOU.view = localLinearLayout;
    }
    View localView = this.iOU.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.iOb = parama;
    Object localObject5 = parama.context;
    aQz();
    aQw();
    aQx();
    LayoutInflater.from((Context)localObject5).inflate(2131495093, this.iOI);
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
    if (TextUtils.isEmpty(this.iOb.iOu))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.iOb.iOv)) {
        break label1294;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.iOb.iOw)) {
        break label1305;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.iOb.iOx);
      ((Button)localObject4).setTextColor(this.iOb.iOy);
      ((TextView)localObject1).setTextColor(this.iOb.iOz);
      ((RelativeLayout)localObject2).setBackgroundColor(this.iOb.iOB);
      ((Button)localObject3).setTextSize(this.iOb.iOC);
      ((Button)localObject4).setTextSize(this.iOb.iOC);
      ((TextView)localObject1).setTextSize(this.iOb.iOD);
      parama = this.iOU;
      localObject1 = this.iOb.iOi;
      i = this.iOb.iOt;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.iOi = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.iOb.iOe != null) {
        this.iOU.iPr = new com.tencent.mm.picker.d.a()
        {
          public final void aQv()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.iPb.parse(c.b(c.this).aQH());
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
      if ((this.iOb.startYear != 0) && (this.iOb.endYear != 0) && (this.iOb.startYear <= this.iOb.endYear))
      {
        this.iOU.startYear = this.iOb.startYear;
        this.iOU.endYear = this.iOb.endYear;
      }
      if ((this.iOb.iOk == null) || (this.iOb.iOl == null)) {
        break label1316;
      }
      if (this.iOb.iOk.getTimeInMillis() > this.iOb.iOl.getTimeInMillis())
      {
        Log.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null");
        this.iOb.iOk = null;
      }
      parama = this.iOU;
      localObject1 = this.iOb.iOk;
      localObject2 = this.iOb.iOl;
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
      parama.iPj = j;
      parama.iPl = k;
      if ((this.iOb.iOk == null) || (this.iOb.iOl == null)) {
        break label1777;
      }
      if ((this.iOb.iOj != null) && (this.iOb.iOj.getTimeInMillis() >= this.iOb.iOk.getTimeInMillis())) {
        break label1736;
      }
      this.iOb.iOj = this.iOb.iOk;
      if (this.iOb.iOj != null) {
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
      parama = this.iOU;
      parama.iPq = i1;
      parama.iPc = ((WheelView)parama.view.findViewById(2131307138));
      parama.iPc.setAdapter(new com.tencent.mm.picker.a.c(parama.startYear, parama.endYear));
      parama.iPc.setCurrentItem(i1 - parama.startYear);
      parama.iPc.setGravity(parama.gravity);
      parama.iPd = ((WheelView)parama.view.findViewById(2131302450));
      if (parama.startYear != parama.endYear) {
        break label1913;
      }
      parama.iPd.setAdapter(new com.tencent.mm.picker.a.c(parama.iPi, parama.iPj, new b(parama.ctx)));
      parama.iPd.setCurrentItem(n + 1 - parama.iPi);
      label844:
      parama.iPd.setGravity(parama.gravity);
      parama.iPe = ((WheelView)parama.view.findViewById(2131298935));
      if ((parama.startYear != parama.endYear) || (parama.iPi != parama.iPj)) {
        break label2226;
      }
      if (!parama.iPu.contains(String.valueOf(n + 1))) {
        break label2063;
      }
      if (parama.iPl > 31) {
        parama.iPl = 31;
      }
      parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, parama.iPl));
      label950:
      parama.iPe.setCurrentItem(m - parama.iPk);
      parama.iPe.setGravity(parama.gravity);
      parama.iPf = ((WheelView)parama.view.findViewById(2131300765));
      parama.iPf.setAdapter(new com.tencent.mm.picker.a.c(parama.iPm, parama.iPo));
      parama.iPf.setCurrentItem(k - parama.iPm);
      parama.iPf.setGravity(parama.gravity);
      parama.iPg = ((WheelView)parama.view.findViewById(2131302275));
      if ((k != parama.iPm) || (parama.iPm != parama.iPo)) {
        break label2841;
      }
      parama.iPg.setAdapter(new com.tencent.mm.picker.a.c(parama.iPn, parama.iPp));
      if (j >= parama.iPn) {
        break label2808;
      }
      parama.iPg.setCurrentItem(0);
    }
    label1294:
    label2063:
    label2841:
    for (;;)
    {
      parama.iPg.setGravity(parama.gravity);
      parama.iPh = ((WheelView)parama.view.findViewById(2131304457));
      parama.iPh.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
      parama.iPh.setCurrentItem(i);
      parama.iPh.setGravity(parama.gravity);
      parama.iPf.setOnItemSelectedListener(new e.3(parama));
      parama.iPc.setOnItemSelectedListener(new e.2(parama));
      parama.iPd.setOnItemSelectedListener(new e.1(parama));
      parama.b(parama.iPe);
      parama.b(parama.iPf);
      parama.b(parama.iPg);
      parama.b(parama.iPh);
      if (parama.iOi.length == 6) {
        break label2994;
      }
      parama = new IllegalArgumentException("type[] length is not 6");
      AppMethodBeat.o(175354);
      throw parama;
      parama = this.iOb.iOu;
      break;
      parama = this.iOb.iOv;
      break label167;
      label1305:
      parama = this.iOb.iOw;
      break label189;
      label1316:
      if (this.iOb.iOk != null)
      {
        if (this.iOb.iOk.get(1) >= 1900) {
          break label479;
        }
        Log.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null");
        this.iOb.iOk = null;
        break label479;
      }
      if ((this.iOb.iOl == null) || (this.iOb.iOl.get(1) <= 2100)) {
        break label479;
      }
      Log.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null");
      this.iOb.iOk = null;
      break label479;
      if (i != parama.startYear) {
        break label560;
      }
      if (j > parama.iPi)
      {
        parama.endYear = i;
        parama.iPj = j;
        parama.iPl = k;
        break label560;
      }
      if ((j != parama.iPi) || (k <= parama.iPk)) {
        break label560;
      }
      parama.endYear = i;
      parama.iPj = j;
      parama.iPl = k;
      break label560;
      label1483:
      if ((localObject1 != null) && (localObject2 == null))
      {
        i = ((Calendar)localObject1).get(1);
        j = ((Calendar)localObject1).get(2) + 1;
        k = ((Calendar)localObject1).get(5);
        if (i < parama.endYear)
        {
          parama.iPi = j;
          parama.iPk = k;
          parama.startYear = i;
          break label560;
        }
        if (i != parama.endYear) {
          break label560;
        }
        if (j < parama.iPj)
        {
          parama.iPi = j;
          parama.iPk = k;
          parama.startYear = i;
          break label560;
        }
        if ((j != parama.iPj) || (k >= parama.iPl)) {
          break label560;
        }
        parama.iPi = j;
        parama.iPk = k;
        parama.startYear = i;
        break label560;
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        break label560;
      }
      parama.startYear = ((Calendar)localObject1).get(1);
      parama.endYear = ((Calendar)localObject2).get(1);
      parama.iPi = (((Calendar)localObject1).get(2) + 1);
      parama.iPj = (((Calendar)localObject2).get(2) + 1);
      parama.iPk = ((Calendar)localObject1).get(5);
      parama.iPl = ((Calendar)localObject2).get(5);
      parama.iPm = ((Calendar)localObject1).get(11);
      parama.iPn = ((Calendar)localObject1).get(12);
      parama.iPo = ((Calendar)localObject2).get(11);
      parama.iPp = ((Calendar)localObject2).get(12);
      break label560;
      label1736:
      if (this.iOb.iOj.getTimeInMillis() <= this.iOb.iOl.getTimeInMillis()) {
        break label628;
      }
      this.iOb.iOj = this.iOb.iOl;
      break label628;
      label1777:
      if (this.iOb.iOk != null)
      {
        this.iOb.iOj = this.iOb.iOk;
        break label628;
      }
      if (this.iOb.iOl == null) {
        break label628;
      }
      this.iOb.iOj = this.iOb.iOl;
      break label628;
      label1831:
      i1 = this.iOb.iOj.get(1);
      n = this.iOb.iOj.get(2);
      m = this.iOb.iOj.get(5);
      k = this.iOb.iOj.get(11);
      j = this.iOb.iOj.get(12);
      i = this.iOb.iOj.get(13);
      break label692;
      label1913:
      if (i1 == parama.startYear)
      {
        parama.iPd.setAdapter(new com.tencent.mm.picker.a.c(parama.iPi, 12, new b(parama.ctx)));
        parama.iPd.setCurrentItem(n + 1 - parama.iPi);
        break label844;
      }
      if (i1 == parama.endYear)
      {
        parama.iPd.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iPj, new b(parama.ctx)));
        parama.iPd.setCurrentItem(n);
        break label844;
      }
      parama.iPd.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new b(parama.ctx)));
      parama.iPd.setCurrentItem(n);
      break label844;
      if (parama.iPw.contains(String.valueOf(n + 1)))
      {
        if (parama.iPl > 30) {
          parama.iPl = 30;
        }
        parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, parama.iPl));
        break label950;
      }
      if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (parama.iPl > 29) {
          parama.iPl = 29;
        }
        parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, parama.iPl));
        break label950;
      }
      if (parama.iPl > 28) {
        parama.iPl = 28;
      }
      parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, parama.iPl));
      break label950;
      label2226:
      if ((i1 == parama.startYear) && (n + 1 == parama.iPi))
      {
        if (parama.iPu.contains(String.valueOf(n + 1))) {
          parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, 31));
        }
        for (;;)
        {
          parama.iPe.setCurrentItem(m - parama.iPk);
          break;
          if (parama.iPw.contains(String.valueOf(n + 1))) {
            parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, 30));
          } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
            parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, 29));
          } else {
            parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(parama.iPk, 28));
          }
        }
      }
      if ((i1 == parama.endYear) && (n + 1 == parama.iPj))
      {
        if (parama.iPu.contains(String.valueOf(n + 1)))
        {
          if (parama.iPl > 31) {
            parama.iPl = 31;
          }
          parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iPl));
        }
        for (;;)
        {
          parama.iPe.setCurrentItem(m - 1);
          break;
          if (parama.iPw.contains(String.valueOf(n + 1)))
          {
            if (parama.iPl > 30) {
              parama.iPl = 30;
            }
            parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iPl));
          }
          else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
          {
            if (parama.iPl > 29) {
              parama.iPl = 29;
            }
            parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iPl));
          }
          else
          {
            if (parama.iPl > 28) {
              parama.iPl = 28;
            }
            parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iPl));
          }
        }
      }
      if (parama.iPu.contains(String.valueOf(n + 1))) {
        parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
      }
      for (;;)
      {
        parama.iPe.setCurrentItem(m - 1);
        break;
        if (parama.iPw.contains(String.valueOf(n + 1))) {
          parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
        } else {
          parama.iPe.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
        }
      }
      label2808:
      if (j > parama.iPp)
      {
        parama.iPg.setCurrentItem(parama.iPp);
      }
      else
      {
        parama.iPg.setCurrentItem(j);
        continue;
        if (k == parama.iPm)
        {
          parama.iPg.setAdapter(new com.tencent.mm.picker.a.c(parama.iPn, 59));
          if (j < parama.iPn) {
            parama.iPg.setCurrentItem(0);
          } else {
            parama.iPg.setCurrentItem(j - parama.iPn);
          }
        }
        else if (k == parama.iPo)
        {
          parama.iPg.setAdapter(new com.tencent.mm.picker.a.c(0, parama.iPp));
          if (j >= parama.iPp) {
            parama.iPg.setCurrentItem(parama.iPp);
          } else {
            parama.iPg.setCurrentItem(j);
          }
        }
        else
        {
          parama.iPg.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
          parama.iPg.setCurrentItem(j);
        }
      }
    }
    label1412:
    label2994:
    e.aH(parama.aQG());
    if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      parama = this.iOU;
      localObject1 = this.iOb.iOm;
      localObject2 = this.iOb.iOn;
      localObject3 = this.iOb.iOo;
      localObject4 = this.iOb.iOp;
      localObject5 = this.iOb.iOq;
      String str = this.iOb.iOr;
      if (localObject1 == null) {
        break label3365;
      }
      parama.iPc.setLabel((String)localObject1);
      if (localObject2 == null) {
        break label3388;
      }
      parama.iPd.setLabel((String)localObject2);
      label3113:
      if (localObject3 == null) {
        break label3411;
      }
      parama.iPe.setLabel((String)localObject3);
      label3127:
      if (localObject4 == null) {
        break label3434;
      }
      parama.iPf.setLabel((String)localObject4);
      label3141:
      if (localObject5 == null) {
        break label3457;
      }
      parama.iPg.setLabel((String)localObject5);
      label3155:
      if (str == null) {
        break label3480;
      }
      parama.iPh.setLabel(str);
    }
    for (;;)
    {
      fl(this.iOb.ov);
      this.iOU.setDividerColor(this.iOb.iNG);
      this.iOU.iOH = this.iOb.iOH;
      parama = this.iOU;
      boolean bool = this.iOb.iOg;
      parama.iPc.setCyclic(bool);
      parama.iPd.setCyclic(bool);
      parama.iPe.setCyclic(bool);
      parama.iPf.setCyclic(bool);
      parama.iPg.setCyclic(bool);
      parama.iPh.setCyclic(bool);
      this.iOU.iOF = this.iOb.iOF;
      parama = this.iOU;
      bool = this.iOb.iNz;
      parama.iPe.iNz = bool;
      parama.iPd.iNz = bool;
      parama.iPc.iNz = bool;
      parama.iPf.iNz = bool;
      parama.iPg.iNz = bool;
      parama.iPh.iNz = bool;
      AppMethodBeat.o(175354);
      return;
      label3365:
      parama.iPc.setLabel(parama.view.getContext().getString(2131761931));
      break;
      label3388:
      parama.iPd.setLabel(parama.view.getContext().getString(2131761928));
      break label3113;
      label3411:
      parama.iPe.setLabel(parama.view.getContext().getString(2131761925));
      break label3127;
      label3434:
      parama.iPf.setLabel(parama.view.getContext().getString(2131761926));
      break label3141;
      label3457:
      parama.iPg.setLabel(parama.view.getContext().getString(2131761927));
      break label3155;
      label3480:
      parama.iPh.setLabel(parama.view.getContext().getString(2131761929));
    }
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.iOU;
    locale.iPe.setPadding(0, paramInt1, 0, paramInt2);
    locale.iPf.setPadding(0, paramInt1, 0, paramInt2);
    locale.iPg.setPadding(0, paramInt1, 0, paramInt2);
    locale.iPc.setPadding(0, paramInt1, 0, paramInt2);
    locale.iPd.setPadding(0, paramInt1, 0, paramInt2);
    locale.iPh.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    if (((String)paramView.getTag()).equals("submit")) {
      aQB();
    }
    dismiss();
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.iOU != null)
    {
      e locale = this.iOU;
      locale.iPe.setDividerHeight(paramFloat);
      locale.iPf.setDividerHeight(paramFloat);
      locale.iPg.setDividerHeight(paramFloat);
      locale.iPc.setDividerHeight(paramFloat);
      locale.iPd.setDividerHeight(paramFloat);
      locale.iPh.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */