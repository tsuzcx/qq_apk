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
  public e iMb;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.iMb = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final boolean aQb()
  {
    return this.iLi.iLN;
  }
  
  public final void aQc()
  {
    AppMethodBeat.i(175356);
    if (this.iLi.iLk != null) {
      try
      {
        Date localDate = e.iMi.parse(this.iMb.aQi());
        this.iLi.iLk.a(localDate);
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
  
  public final View aQe()
  {
    AppMethodBeat.i(175357);
    if (this.iMb.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495093, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131305844);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.iMb.view = localLinearLayout;
    }
    View localView = this.iMb.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.iLi = parama;
    Object localObject5 = parama.context;
    aQa();
    aPX();
    aPY();
    LayoutInflater.from((Context)localObject5).inflate(2131495093, this.iLP);
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
    if (TextUtils.isEmpty(this.iLi.iLB))
    {
      parama = ((Context)localObject5).getResources().getString(2131761930);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.iLi.iLC)) {
        break label1294;
      }
      parama = ((Context)localObject5).getResources().getString(2131761924);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.iLi.iLD)) {
        break label1305;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.iLi.iLE);
      ((Button)localObject4).setTextColor(this.iLi.iLF);
      ((TextView)localObject1).setTextColor(this.iLi.iLG);
      ((RelativeLayout)localObject2).setBackgroundColor(this.iLi.iLI);
      ((Button)localObject3).setTextSize(this.iLi.iLJ);
      ((Button)localObject4).setTextSize(this.iLi.iLJ);
      ((TextView)localObject1).setTextSize(this.iLi.iLK);
      parama = this.iMb;
      localObject1 = this.iLi.iLp;
      i = this.iLi.iLA;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.iLp = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.iLi.iLl != null) {
        this.iMb.iMy = new com.tencent.mm.picker.d.a()
        {
          public final void aPW()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.iMi.parse(c.b(c.this).aQi());
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
      if ((this.iLi.startYear != 0) && (this.iLi.endYear != 0) && (this.iLi.startYear <= this.iLi.endYear))
      {
        this.iMb.startYear = this.iLi.startYear;
        this.iMb.endYear = this.iLi.endYear;
      }
      if ((this.iLi.iLr == null) || (this.iLi.iLs == null)) {
        break label1316;
      }
      if (this.iLi.iLr.getTimeInMillis() > this.iLi.iLs.getTimeInMillis())
      {
        Log.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null");
        this.iLi.iLr = null;
      }
      parama = this.iMb;
      localObject1 = this.iLi.iLr;
      localObject2 = this.iLi.iLs;
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
      parama.iMq = j;
      parama.iMs = k;
      if ((this.iLi.iLr == null) || (this.iLi.iLs == null)) {
        break label1777;
      }
      if ((this.iLi.iLq != null) && (this.iLi.iLq.getTimeInMillis() >= this.iLi.iLr.getTimeInMillis())) {
        break label1736;
      }
      this.iLi.iLq = this.iLi.iLr;
      if (this.iLi.iLq != null) {
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
      parama = this.iMb;
      parama.iMx = i1;
      parama.iMj = ((WheelView)parama.view.findViewById(2131307138));
      parama.iMj.setAdapter(new com.tencent.mm.picker.a.c(parama.startYear, parama.endYear));
      parama.iMj.setCurrentItem(i1 - parama.startYear);
      parama.iMj.setGravity(parama.gravity);
      parama.iMk = ((WheelView)parama.view.findViewById(2131302450));
      if (parama.startYear != parama.endYear) {
        break label1913;
      }
      parama.iMk.setAdapter(new com.tencent.mm.picker.a.c(parama.iMp, parama.iMq, new b(parama.ctx)));
      parama.iMk.setCurrentItem(n + 1 - parama.iMp);
      label844:
      parama.iMk.setGravity(parama.gravity);
      parama.iMl = ((WheelView)parama.view.findViewById(2131298935));
      if ((parama.startYear != parama.endYear) || (parama.iMp != parama.iMq)) {
        break label2226;
      }
      if (!parama.iMB.contains(String.valueOf(n + 1))) {
        break label2063;
      }
      if (parama.iMs > 31) {
        parama.iMs = 31;
      }
      parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, parama.iMs));
      label950:
      parama.iMl.setCurrentItem(m - parama.iMr);
      parama.iMl.setGravity(parama.gravity);
      parama.iMm = ((WheelView)parama.view.findViewById(2131300765));
      parama.iMm.setAdapter(new com.tencent.mm.picker.a.c(parama.iMt, parama.iMv));
      parama.iMm.setCurrentItem(k - parama.iMt);
      parama.iMm.setGravity(parama.gravity);
      parama.iMn = ((WheelView)parama.view.findViewById(2131302275));
      if ((k != parama.iMt) || (parama.iMt != parama.iMv)) {
        break label2841;
      }
      parama.iMn.setAdapter(new com.tencent.mm.picker.a.c(parama.iMu, parama.iMw));
      if (j >= parama.iMu) {
        break label2808;
      }
      parama.iMn.setCurrentItem(0);
    }
    label1294:
    label2063:
    label2841:
    for (;;)
    {
      parama.iMn.setGravity(parama.gravity);
      parama.iMo = ((WheelView)parama.view.findViewById(2131304457));
      parama.iMo.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
      parama.iMo.setCurrentItem(i);
      parama.iMo.setGravity(parama.gravity);
      parama.iMm.setOnItemSelectedListener(new e.3(parama));
      parama.iMj.setOnItemSelectedListener(new e.2(parama));
      parama.iMk.setOnItemSelectedListener(new e.1(parama));
      parama.b(parama.iMl);
      parama.b(parama.iMm);
      parama.b(parama.iMn);
      parama.b(parama.iMo);
      if (parama.iLp.length == 6) {
        break label2994;
      }
      parama = new IllegalArgumentException("type[] length is not 6");
      AppMethodBeat.o(175354);
      throw parama;
      parama = this.iLi.iLB;
      break;
      parama = this.iLi.iLC;
      break label167;
      label1305:
      parama = this.iLi.iLD;
      break label189;
      label1316:
      if (this.iLi.iLr != null)
      {
        if (this.iLi.iLr.get(1) >= 1900) {
          break label479;
        }
        Log.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null");
        this.iLi.iLr = null;
        break label479;
      }
      if ((this.iLi.iLs == null) || (this.iLi.iLs.get(1) <= 2100)) {
        break label479;
      }
      Log.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null");
      this.iLi.iLr = null;
      break label479;
      if (i != parama.startYear) {
        break label560;
      }
      if (j > parama.iMp)
      {
        parama.endYear = i;
        parama.iMq = j;
        parama.iMs = k;
        break label560;
      }
      if ((j != parama.iMp) || (k <= parama.iMr)) {
        break label560;
      }
      parama.endYear = i;
      parama.iMq = j;
      parama.iMs = k;
      break label560;
      label1483:
      if ((localObject1 != null) && (localObject2 == null))
      {
        i = ((Calendar)localObject1).get(1);
        j = ((Calendar)localObject1).get(2) + 1;
        k = ((Calendar)localObject1).get(5);
        if (i < parama.endYear)
        {
          parama.iMp = j;
          parama.iMr = k;
          parama.startYear = i;
          break label560;
        }
        if (i != parama.endYear) {
          break label560;
        }
        if (j < parama.iMq)
        {
          parama.iMp = j;
          parama.iMr = k;
          parama.startYear = i;
          break label560;
        }
        if ((j != parama.iMq) || (k >= parama.iMs)) {
          break label560;
        }
        parama.iMp = j;
        parama.iMr = k;
        parama.startYear = i;
        break label560;
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        break label560;
      }
      parama.startYear = ((Calendar)localObject1).get(1);
      parama.endYear = ((Calendar)localObject2).get(1);
      parama.iMp = (((Calendar)localObject1).get(2) + 1);
      parama.iMq = (((Calendar)localObject2).get(2) + 1);
      parama.iMr = ((Calendar)localObject1).get(5);
      parama.iMs = ((Calendar)localObject2).get(5);
      parama.iMt = ((Calendar)localObject1).get(11);
      parama.iMu = ((Calendar)localObject1).get(12);
      parama.iMv = ((Calendar)localObject2).get(11);
      parama.iMw = ((Calendar)localObject2).get(12);
      break label560;
      label1736:
      if (this.iLi.iLq.getTimeInMillis() <= this.iLi.iLs.getTimeInMillis()) {
        break label628;
      }
      this.iLi.iLq = this.iLi.iLs;
      break label628;
      label1777:
      if (this.iLi.iLr != null)
      {
        this.iLi.iLq = this.iLi.iLr;
        break label628;
      }
      if (this.iLi.iLs == null) {
        break label628;
      }
      this.iLi.iLq = this.iLi.iLs;
      break label628;
      label1831:
      i1 = this.iLi.iLq.get(1);
      n = this.iLi.iLq.get(2);
      m = this.iLi.iLq.get(5);
      k = this.iLi.iLq.get(11);
      j = this.iLi.iLq.get(12);
      i = this.iLi.iLq.get(13);
      break label692;
      label1913:
      if (i1 == parama.startYear)
      {
        parama.iMk.setAdapter(new com.tencent.mm.picker.a.c(parama.iMp, 12, new b(parama.ctx)));
        parama.iMk.setCurrentItem(n + 1 - parama.iMp);
        break label844;
      }
      if (i1 == parama.endYear)
      {
        parama.iMk.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iMq, new b(parama.ctx)));
        parama.iMk.setCurrentItem(n);
        break label844;
      }
      parama.iMk.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new b(parama.ctx)));
      parama.iMk.setCurrentItem(n);
      break label844;
      if (parama.iMC.contains(String.valueOf(n + 1)))
      {
        if (parama.iMs > 30) {
          parama.iMs = 30;
        }
        parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, parama.iMs));
        break label950;
      }
      if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (parama.iMs > 29) {
          parama.iMs = 29;
        }
        parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, parama.iMs));
        break label950;
      }
      if (parama.iMs > 28) {
        parama.iMs = 28;
      }
      parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, parama.iMs));
      break label950;
      label2226:
      if ((i1 == parama.startYear) && (n + 1 == parama.iMp))
      {
        if (parama.iMB.contains(String.valueOf(n + 1))) {
          parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, 31));
        }
        for (;;)
        {
          parama.iMl.setCurrentItem(m - parama.iMr);
          break;
          if (parama.iMC.contains(String.valueOf(n + 1))) {
            parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, 30));
          } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
            parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, 29));
          } else {
            parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(parama.iMr, 28));
          }
        }
      }
      if ((i1 == parama.endYear) && (n + 1 == parama.iMq))
      {
        if (parama.iMB.contains(String.valueOf(n + 1)))
        {
          if (parama.iMs > 31) {
            parama.iMs = 31;
          }
          parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iMs));
        }
        for (;;)
        {
          parama.iMl.setCurrentItem(m - 1);
          break;
          if (parama.iMC.contains(String.valueOf(n + 1)))
          {
            if (parama.iMs > 30) {
              parama.iMs = 30;
            }
            parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iMs));
          }
          else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
          {
            if (parama.iMs > 29) {
              parama.iMs = 29;
            }
            parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iMs));
          }
          else
          {
            if (parama.iMs > 28) {
              parama.iMs = 28;
            }
            parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, parama.iMs));
          }
        }
      }
      if (parama.iMB.contains(String.valueOf(n + 1))) {
        parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
      }
      for (;;)
      {
        parama.iMl.setCurrentItem(m - 1);
        break;
        if (parama.iMC.contains(String.valueOf(n + 1))) {
          parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
        } else {
          parama.iMl.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
        }
      }
      label2808:
      if (j > parama.iMw)
      {
        parama.iMn.setCurrentItem(parama.iMw);
      }
      else
      {
        parama.iMn.setCurrentItem(j);
        continue;
        if (k == parama.iMt)
        {
          parama.iMn.setAdapter(new com.tencent.mm.picker.a.c(parama.iMu, 59));
          if (j < parama.iMu) {
            parama.iMn.setCurrentItem(0);
          } else {
            parama.iMn.setCurrentItem(j - parama.iMu);
          }
        }
        else if (k == parama.iMv)
        {
          parama.iMn.setAdapter(new com.tencent.mm.picker.a.c(0, parama.iMw));
          if (j >= parama.iMw) {
            parama.iMn.setCurrentItem(parama.iMw);
          } else {
            parama.iMn.setCurrentItem(j);
          }
        }
        else
        {
          parama.iMn.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
          parama.iMn.setCurrentItem(j);
        }
      }
    }
    label1412:
    label2994:
    e.aH(parama.aQh());
    if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      parama = this.iMb;
      localObject1 = this.iLi.iLt;
      localObject2 = this.iLi.iLu;
      localObject3 = this.iLi.iLv;
      localObject4 = this.iLi.iLw;
      localObject5 = this.iLi.iLx;
      String str = this.iLi.iLy;
      if (localObject1 == null) {
        break label3365;
      }
      parama.iMj.setLabel((String)localObject1);
      if (localObject2 == null) {
        break label3388;
      }
      parama.iMk.setLabel((String)localObject2);
      label3113:
      if (localObject3 == null) {
        break label3411;
      }
      parama.iMl.setLabel((String)localObject3);
      label3127:
      if (localObject4 == null) {
        break label3434;
      }
      parama.iMm.setLabel((String)localObject4);
      label3141:
      if (localObject5 == null) {
        break label3457;
      }
      parama.iMn.setLabel((String)localObject5);
      label3155:
      if (str == null) {
        break label3480;
      }
      parama.iMo.setLabel(str);
    }
    for (;;)
    {
      fk(this.iLi.ov);
      this.iMb.setDividerColor(this.iLi.iKN);
      this.iMb.iLO = this.iLi.iLO;
      parama = this.iMb;
      boolean bool = this.iLi.iLn;
      parama.iMj.setCyclic(bool);
      parama.iMk.setCyclic(bool);
      parama.iMl.setCyclic(bool);
      parama.iMm.setCyclic(bool);
      parama.iMn.setCyclic(bool);
      parama.iMo.setCyclic(bool);
      this.iMb.iLM = this.iLi.iLM;
      parama = this.iMb;
      bool = this.iLi.iKG;
      parama.iMl.iKG = bool;
      parama.iMk.iKG = bool;
      parama.iMj.iKG = bool;
      parama.iMm.iKG = bool;
      parama.iMn.iKG = bool;
      parama.iMo.iKG = bool;
      AppMethodBeat.o(175354);
      return;
      label3365:
      parama.iMj.setLabel(parama.view.getContext().getString(2131761931));
      break;
      label3388:
      parama.iMk.setLabel(parama.view.getContext().getString(2131761928));
      break label3113;
      label3411:
      parama.iMl.setLabel(parama.view.getContext().getString(2131761925));
      break label3127;
      label3434:
      parama.iMm.setLabel(parama.view.getContext().getString(2131761926));
      break label3141;
      label3457:
      parama.iMn.setLabel(parama.view.getContext().getString(2131761927));
      break label3155;
      label3480:
      parama.iMo.setLabel(parama.view.getContext().getString(2131761929));
    }
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.iMb;
    locale.iMl.setPadding(0, paramInt1, 0, paramInt2);
    locale.iMm.setPadding(0, paramInt1, 0, paramInt2);
    locale.iMn.setPadding(0, paramInt1, 0, paramInt2);
    locale.iMj.setPadding(0, paramInt1, 0, paramInt2);
    locale.iMk.setPadding(0, paramInt1, 0, paramInt2);
    locale.iMo.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    if (((String)paramView.getTag()).equals("submit")) {
      aQc();
    }
    dismiss();
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.iMb != null)
    {
      e locale = this.iMb;
      locale.iMl.setDividerHeight(paramFloat);
      locale.iMm.setDividerHeight(paramFloat);
      locale.iMn.setDividerHeight(paramFloat);
      locale.iMj.setDividerHeight(paramFloat);
      locale.iMk.setDividerHeight(paramFloat);
      locale.iMo.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */