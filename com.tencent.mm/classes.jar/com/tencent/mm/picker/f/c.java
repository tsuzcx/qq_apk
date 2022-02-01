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
  public e isY;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.isY = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final boolean aMQ()
  {
    return this.isf.isK;
  }
  
  public final void aMR()
  {
    AppMethodBeat.i(175356);
    if (this.isf.ish != null) {
      try
      {
        Date localDate = e.itf.parse(this.isY.aMX());
        this.isf.ish.a(localDate);
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
  
  public final View aMT()
  {
    AppMethodBeat.i(175357);
    if (this.isY.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495093, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.isY.view = localLinearLayout;
    }
    View localView = this.isY.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.isf = parama;
    Object localObject5 = parama.context;
    aMP();
    aMM();
    aMN();
    LayoutInflater.from((Context)localObject5).inflate(2131495093, this.isM);
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
    if (TextUtils.isEmpty(this.isf.isy))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.isf.isz)) {
        break label1294;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.isf.isA)) {
        break label1305;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.isf.isB);
      ((Button)localObject4).setTextColor(this.isf.isC);
      ((TextView)localObject1).setTextColor(this.isf.isD);
      ((RelativeLayout)localObject2).setBackgroundColor(this.isf.isF);
      ((Button)localObject3).setTextSize(this.isf.isG);
      ((Button)localObject4).setTextSize(this.isf.isG);
      ((TextView)localObject1).setTextSize(this.isf.isH);
      parama = this.isY;
      localObject1 = this.isf.ism;
      i = this.isf.isx;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.ism = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.isf.isi != null) {
        this.isY.itv = new com.tencent.mm.picker.d.a()
        {
          public final void aML()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.itf.parse(c.b(c.this).aMX());
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
      if ((this.isf.startYear != 0) && (this.isf.endYear != 0) && (this.isf.startYear <= this.isf.endYear))
      {
        this.isY.startYear = this.isf.startYear;
        this.isY.endYear = this.isf.endYear;
      }
      if ((this.isf.iso == null) || (this.isf.isp == null)) {
        break label1316;
      }
      if (this.isf.iso.getTimeInMillis() > this.isf.isp.getTimeInMillis())
      {
        Log.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null");
        this.isf.iso = null;
      }
      parama = this.isY;
      localObject1 = this.isf.iso;
      localObject2 = this.isf.isp;
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
      parama.itn = j;
      parama.itp = k;
      if ((this.isf.iso == null) || (this.isf.isp == null)) {
        break label1777;
      }
      if ((this.isf.isn != null) && (this.isf.isn.getTimeInMillis() >= this.isf.iso.getTimeInMillis())) {
        break label1736;
      }
      this.isf.isn = this.isf.iso;
      if (this.isf.isn != null) {
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
      parama = this.isY;
      parama.itu = i1;
      parama.itg = ((WheelView)parama.view.findViewById(2131307138));
      parama.itg.setAdapter(new com.tencent.mm.picker.a.c(parama.startYear, parama.endYear));
      parama.itg.setCurrentItem(i1 - parama.startYear);
      parama.itg.setGravity(parama.gravity);
      parama.ith = ((WheelView)parama.view.findViewById(2131302450));
      if (parama.startYear != parama.endYear) {
        break label1913;
      }
      parama.ith.setAdapter(new com.tencent.mm.picker.a.c(parama.itm, parama.itn, new b(parama.ctx)));
      parama.ith.setCurrentItem(n + 1 - parama.itm);
      label844:
      parama.ith.setGravity(parama.gravity);
      parama.iti = ((WheelView)parama.view.findViewById(2131298935));
      if ((parama.startYear != parama.endYear) || (parama.itm != parama.itn)) {
        break label2226;
      }
      if (!parama.ity.contains(String.valueOf(n + 1))) {
        break label2063;
      }
      if (parama.itp > 31) {
        parama.itp = 31;
      }
      parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, parama.itp));
      label950:
      parama.iti.setCurrentItem(m - parama.ito);
      parama.iti.setGravity(parama.gravity);
      parama.itj = ((WheelView)parama.view.findViewById(2131300765));
      parama.itj.setAdapter(new com.tencent.mm.picker.a.c(parama.itq, parama.its));
      parama.itj.setCurrentItem(k - parama.itq);
      parama.itj.setGravity(parama.gravity);
      parama.itk = ((WheelView)parama.view.findViewById(2131302275));
      if ((k != parama.itq) || (parama.itq != parama.its)) {
        break label2841;
      }
      parama.itk.setAdapter(new com.tencent.mm.picker.a.c(parama.itr, parama.itt));
      if (j >= parama.itr) {
        break label2808;
      }
      parama.itk.setCurrentItem(0);
    }
    label1294:
    label2063:
    label2841:
    for (;;)
    {
      parama.itk.setGravity(parama.gravity);
      parama.itl = ((WheelView)parama.view.findViewById(2131304457));
      parama.itl.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
      parama.itl.setCurrentItem(i);
      parama.itl.setGravity(parama.gravity);
      parama.itj.setOnItemSelectedListener(new e.3(parama));
      parama.itg.setOnItemSelectedListener(new e.2(parama));
      parama.ith.setOnItemSelectedListener(new e.1(parama));
      parama.b(parama.iti);
      parama.b(parama.itj);
      parama.b(parama.itk);
      parama.b(parama.itl);
      if (parama.ism.length == 6) {
        break label2994;
      }
      parama = new IllegalArgumentException("type[] length is not 6");
      AppMethodBeat.o(175354);
      throw parama;
      parama = this.isf.isy;
      break;
      parama = this.isf.isz;
      break label167;
      label1305:
      parama = this.isf.isA;
      break label189;
      label1316:
      if (this.isf.iso != null)
      {
        if (this.isf.iso.get(1) >= 1900) {
          break label479;
        }
        Log.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null");
        this.isf.iso = null;
        break label479;
      }
      if ((this.isf.isp == null) || (this.isf.isp.get(1) <= 2100)) {
        break label479;
      }
      Log.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null");
      this.isf.iso = null;
      break label479;
      if (i != parama.startYear) {
        break label560;
      }
      if (j > parama.itm)
      {
        parama.endYear = i;
        parama.itn = j;
        parama.itp = k;
        break label560;
      }
      if ((j != parama.itm) || (k <= parama.ito)) {
        break label560;
      }
      parama.endYear = i;
      parama.itn = j;
      parama.itp = k;
      break label560;
      label1483:
      if ((localObject1 != null) && (localObject2 == null))
      {
        i = ((Calendar)localObject1).get(1);
        j = ((Calendar)localObject1).get(2) + 1;
        k = ((Calendar)localObject1).get(5);
        if (i < parama.endYear)
        {
          parama.itm = j;
          parama.ito = k;
          parama.startYear = i;
          break label560;
        }
        if (i != parama.endYear) {
          break label560;
        }
        if (j < parama.itn)
        {
          parama.itm = j;
          parama.ito = k;
          parama.startYear = i;
          break label560;
        }
        if ((j != parama.itn) || (k >= parama.itp)) {
          break label560;
        }
        parama.itm = j;
        parama.ito = k;
        parama.startYear = i;
        break label560;
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        break label560;
      }
      parama.startYear = ((Calendar)localObject1).get(1);
      parama.endYear = ((Calendar)localObject2).get(1);
      parama.itm = (((Calendar)localObject1).get(2) + 1);
      parama.itn = (((Calendar)localObject2).get(2) + 1);
      parama.ito = ((Calendar)localObject1).get(5);
      parama.itp = ((Calendar)localObject2).get(5);
      parama.itq = ((Calendar)localObject1).get(11);
      parama.itr = ((Calendar)localObject1).get(12);
      parama.its = ((Calendar)localObject2).get(11);
      parama.itt = ((Calendar)localObject2).get(12);
      break label560;
      label1736:
      if (this.isf.isn.getTimeInMillis() <= this.isf.isp.getTimeInMillis()) {
        break label628;
      }
      this.isf.isn = this.isf.isp;
      break label628;
      label1777:
      if (this.isf.iso != null)
      {
        this.isf.isn = this.isf.iso;
        break label628;
      }
      if (this.isf.isp == null) {
        break label628;
      }
      this.isf.isn = this.isf.isp;
      break label628;
      label1831:
      i1 = this.isf.isn.get(1);
      n = this.isf.isn.get(2);
      m = this.isf.isn.get(5);
      k = this.isf.isn.get(11);
      j = this.isf.isn.get(12);
      i = this.isf.isn.get(13);
      break label692;
      label1913:
      if (i1 == parama.startYear)
      {
        parama.ith.setAdapter(new com.tencent.mm.picker.a.c(parama.itm, 12, new b(parama.ctx)));
        parama.ith.setCurrentItem(n + 1 - parama.itm);
        break label844;
      }
      if (i1 == parama.endYear)
      {
        parama.ith.setAdapter(new com.tencent.mm.picker.a.c(1, parama.itn, new b(parama.ctx)));
        parama.ith.setCurrentItem(n);
        break label844;
      }
      parama.ith.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new b(parama.ctx)));
      parama.ith.setCurrentItem(n);
      break label844;
      if (parama.itz.contains(String.valueOf(n + 1)))
      {
        if (parama.itp > 30) {
          parama.itp = 30;
        }
        parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, parama.itp));
        break label950;
      }
      if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (parama.itp > 29) {
          parama.itp = 29;
        }
        parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, parama.itp));
        break label950;
      }
      if (parama.itp > 28) {
        parama.itp = 28;
      }
      parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, parama.itp));
      break label950;
      label2226:
      if ((i1 == parama.startYear) && (n + 1 == parama.itm))
      {
        if (parama.ity.contains(String.valueOf(n + 1))) {
          parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, 31));
        }
        for (;;)
        {
          parama.iti.setCurrentItem(m - parama.ito);
          break;
          if (parama.itz.contains(String.valueOf(n + 1))) {
            parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, 30));
          } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
            parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, 29));
          } else {
            parama.iti.setAdapter(new com.tencent.mm.picker.a.c(parama.ito, 28));
          }
        }
      }
      if ((i1 == parama.endYear) && (n + 1 == parama.itn))
      {
        if (parama.ity.contains(String.valueOf(n + 1)))
        {
          if (parama.itp > 31) {
            parama.itp = 31;
          }
          parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, parama.itp));
        }
        for (;;)
        {
          parama.iti.setCurrentItem(m - 1);
          break;
          if (parama.itz.contains(String.valueOf(n + 1)))
          {
            if (parama.itp > 30) {
              parama.itp = 30;
            }
            parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, parama.itp));
          }
          else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
          {
            if (parama.itp > 29) {
              parama.itp = 29;
            }
            parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, parama.itp));
          }
          else
          {
            if (parama.itp > 28) {
              parama.itp = 28;
            }
            parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, parama.itp));
          }
        }
      }
      if (parama.ity.contains(String.valueOf(n + 1))) {
        parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
      }
      for (;;)
      {
        parama.iti.setCurrentItem(m - 1);
        break;
        if (parama.itz.contains(String.valueOf(n + 1))) {
          parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
        } else {
          parama.iti.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
        }
      }
      label2808:
      if (j > parama.itt)
      {
        parama.itk.setCurrentItem(parama.itt);
      }
      else
      {
        parama.itk.setCurrentItem(j);
        continue;
        if (k == parama.itq)
        {
          parama.itk.setAdapter(new com.tencent.mm.picker.a.c(parama.itr, 59));
          if (j < parama.itr) {
            parama.itk.setCurrentItem(0);
          } else {
            parama.itk.setCurrentItem(j - parama.itr);
          }
        }
        else if (k == parama.its)
        {
          parama.itk.setAdapter(new com.tencent.mm.picker.a.c(0, parama.itt));
          if (j >= parama.itt) {
            parama.itk.setCurrentItem(parama.itt);
          } else {
            parama.itk.setCurrentItem(j);
          }
        }
        else
        {
          parama.itk.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
          parama.itk.setCurrentItem(j);
        }
      }
    }
    label1412:
    label2994:
    e.aG(parama.aMW());
    if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      parama = this.isY;
      localObject1 = this.isf.isq;
      localObject2 = this.isf.isr;
      localObject3 = this.isf.iss;
      localObject4 = this.isf.ist;
      localObject5 = this.isf.isu;
      String str = this.isf.isv;
      if (localObject1 == null) {
        break label3365;
      }
      parama.itg.setLabel((String)localObject1);
      if (localObject2 == null) {
        break label3388;
      }
      parama.ith.setLabel((String)localObject2);
      label3113:
      if (localObject3 == null) {
        break label3411;
      }
      parama.iti.setLabel((String)localObject3);
      label3127:
      if (localObject4 == null) {
        break label3434;
      }
      parama.itj.setLabel((String)localObject4);
      label3141:
      if (localObject5 == null) {
        break label3457;
      }
      parama.itk.setLabel((String)localObject5);
      label3155:
      if (str == null) {
        break label3480;
      }
      parama.itl.setLabel(str);
    }
    for (;;)
    {
      fg(this.isf.mz);
      this.isY.setDividerColor(this.isf.irK);
      this.isY.isL = this.isf.isL;
      parama = this.isY;
      boolean bool = this.isf.isk;
      parama.itg.setCyclic(bool);
      parama.ith.setCyclic(bool);
      parama.iti.setCyclic(bool);
      parama.itj.setCyclic(bool);
      parama.itk.setCyclic(bool);
      parama.itl.setCyclic(bool);
      this.isY.isJ = this.isf.isJ;
      parama = this.isY;
      bool = this.isf.irD;
      parama.iti.irD = bool;
      parama.ith.irD = bool;
      parama.itg.irD = bool;
      parama.itj.irD = bool;
      parama.itk.irD = bool;
      parama.itl.irD = bool;
      AppMethodBeat.o(175354);
      return;
      label3365:
      parama.itg.setLabel(parama.view.getContext().getString(2131761931));
      break;
      label3388:
      parama.ith.setLabel(parama.view.getContext().getString(2131761928));
      break label3113;
      label3411:
      parama.iti.setLabel(parama.view.getContext().getString(2131761925));
      break label3127;
      label3434:
      parama.itj.setLabel(parama.view.getContext().getString(2131761926));
      break label3141;
      label3457:
      parama.itk.setLabel(parama.view.getContext().getString(2131761927));
      break label3155;
      label3480:
      parama.itl.setLabel(parama.view.getContext().getString(2131761929));
    }
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.isY;
    locale.iti.setPadding(0, paramInt1, 0, paramInt2);
    locale.itj.setPadding(0, paramInt1, 0, paramInt2);
    locale.itk.setPadding(0, paramInt1, 0, paramInt2);
    locale.itg.setPadding(0, paramInt1, 0, paramInt2);
    locale.ith.setPadding(0, paramInt1, 0, paramInt2);
    locale.itl.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    if (((String)paramView.getTag()).equals("submit")) {
      aMR();
    }
    dismiss();
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.isY != null)
    {
      e locale = this.isY;
      locale.iti.setDividerHeight(paramFloat);
      locale.itj.setDividerHeight(paramFloat);
      locale.itk.setDividerHeight(paramFloat);
      locale.itg.setDividerHeight(paramFloat);
      locale.ith.setDividerHeight(paramFloat);
      locale.itl.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */