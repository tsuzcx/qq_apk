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
  public e jLJ;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(175353);
    this.TAG = "TimePickerView";
    this.jLJ = new e(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(175353);
  }
  
  public final void b(com.tencent.mm.picker.c.a parama)
  {
    AppMethodBeat.i(175354);
    this.jKP = parama;
    Object localObject5 = parama.context;
    ble();
    blb();
    blc();
    LayoutInflater.from((Context)localObject5).inflate(2131495932, this.jLx);
    Object localObject1 = (TextView)findViewById(2131309446);
    Object localObject2 = (RelativeLayout)findViewById(2131307202);
    Object localObject3 = (Button)findViewById(2131297822);
    Object localObject4 = (Button)findViewById(2131297816);
    ((Button)localObject3).setTag("submit");
    ((Button)localObject4).setTag("cancel");
    ((Button)localObject3).setOnClickListener(this);
    ((Button)localObject4).setOnClickListener(this);
    label167:
    label189:
    int i;
    label478:
    int j;
    int k;
    label559:
    label627:
    int i1;
    int n;
    int m;
    if (TextUtils.isEmpty(this.jKP.jLj))
    {
      parama = ((Context)localObject5).getResources().getString(2131763936);
      ((Button)localObject3).setText(parama);
      if (!TextUtils.isEmpty(this.jKP.jLk)) {
        break label1293;
      }
      parama = ((Context)localObject5).getResources().getString(2131763930);
      ((Button)localObject4).setText(parama);
      if (!TextUtils.isEmpty(this.jKP.jLl)) {
        break label1304;
      }
      parama = "";
      ((TextView)localObject1).setText(parama);
      ((Button)localObject3).setTextColor(this.jKP.jLm);
      ((Button)localObject4).setTextColor(this.jKP.jLn);
      ((TextView)localObject1).setTextColor(this.jKP.jLo);
      ((RelativeLayout)localObject2).setBackgroundColor(this.jKP.jLq);
      ((Button)localObject3).setTextSize(this.jKP.jLr);
      ((Button)localObject4).setTextSize(this.jKP.jLr);
      ((TextView)localObject1).setTextSize(this.jKP.jLs);
      parama = this.jLJ;
      localObject1 = this.jKP.jKX;
      i = this.jKP.jLi;
      if (parama.view == null) {
        parama.view = null;
      }
      parama.jKX = ((boolean[])localObject1);
      parama.gravity = i;
      if (this.jKP.jKT != null) {
        this.jLJ.jMf = new com.tencent.mm.picker.d.a()
        {
          public final void bla()
          {
            AppMethodBeat.i(175352);
            try
            {
              e.dateFormat.parse(c.b(c.this).getTime());
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
      if ((this.jKP.startYear != 0) && (this.jKP.endYear != 0) && (this.jKP.startYear <= this.jKP.endYear))
      {
        this.jLJ.startYear = this.jKP.startYear;
        this.jLJ.endYear = this.jKP.endYear;
      }
      if ((this.jKP.jKZ == null) || (this.jKP.jLa == null)) {
        break label1315;
      }
      if (this.jKP.jKZ.getTimeInMillis() > this.jKP.jLa.getTimeInMillis())
      {
        Log.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null");
        this.jKP.jKZ = null;
      }
      parama = this.jLJ;
      localObject1 = this.jKP.jKZ;
      localObject2 = this.jKP.jLa;
      if ((localObject1 != null) || (localObject2 == null)) {
        break label1482;
      }
      i = ((Calendar)localObject2).get(1);
      j = ((Calendar)localObject2).get(2) + 1;
      k = ((Calendar)localObject2).get(5);
      if (i <= parama.startYear) {
        break label1411;
      }
      parama.endYear = i;
      parama.jLX = j;
      parama.jLZ = k;
      if ((this.jKP.jKZ == null) || (this.jKP.jLa == null)) {
        break label1776;
      }
      if ((this.jKP.jKY != null) && (this.jKP.jKY.getTimeInMillis() >= this.jKP.jKZ.getTimeInMillis())) {
        break label1735;
      }
      this.jKP.jKY = this.jKP.jKZ;
      if (this.jKP.jKY != null) {
        break label1830;
      }
      parama = Calendar.getInstance();
      parama.setTimeInMillis(System.currentTimeMillis());
      i1 = parama.get(1);
      n = parama.get(2);
      m = parama.get(5);
      k = parama.get(11);
      j = parama.get(12);
      i = parama.get(13);
      label691:
      parama = this.jLJ;
      parama.jMe = i1;
      parama.jLQ = ((WheelView)parama.view.findViewById(2131310679));
      parama.jLQ.setAdapter(new com.tencent.mm.picker.a.c(parama.startYear, parama.endYear));
      parama.jLQ.setCurrentItem(i1 - parama.startYear);
      parama.jLQ.setGravity(parama.gravity);
      parama.jLR = ((WheelView)parama.view.findViewById(2131304853));
      if (parama.startYear != parama.endYear) {
        break label1912;
      }
      parama.jLR.setAdapter(new com.tencent.mm.picker.a.c(parama.jLW, parama.jLX, new com.tencent.mm.picker.a.b(parama.ctx)));
      parama.jLR.setCurrentItem(n + 1 - parama.jLW);
      label843:
      parama.jLR.setGravity(parama.gravity);
      parama.jLS = ((WheelView)parama.view.findViewById(2131299421));
      if ((parama.startYear != parama.endYear) || (parama.jLW != parama.jLX)) {
        break label2225;
      }
      if (!parama.jMi.contains(String.valueOf(n + 1))) {
        break label2062;
      }
      if (parama.jLZ > 31) {
        parama.jLZ = 31;
      }
      parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, parama.jLZ));
      label949:
      parama.jLS.setCurrentItem(m - parama.jLY);
      parama.jLS.setGravity(parama.gravity);
      parama.jLT = ((WheelView)parama.view.findViewById(2131302359));
      parama.jLT.setAdapter(new com.tencent.mm.picker.a.c(parama.jMa, parama.jMc));
      parama.jLT.setCurrentItem(k - parama.jMa);
      parama.jLT.setGravity(parama.gravity);
      parama.jLU = ((WheelView)parama.view.findViewById(2131304668));
      if ((k != parama.jMa) || (parama.jMa != parama.jMc)) {
        break label2840;
      }
      parama.jLU.setAdapter(new com.tencent.mm.picker.a.c(parama.jMb, parama.jMd));
      if (j >= parama.jMb) {
        break label2807;
      }
      parama.jLU.setCurrentItem(0);
    }
    label1293:
    label2062:
    label2840:
    for (;;)
    {
      parama.jLU.setGravity(parama.gravity);
      parama.jLV = ((WheelView)parama.view.findViewById(2131307433));
      parama.jLV.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
      parama.jLV.setCurrentItem(i);
      parama.jLV.setGravity(parama.gravity);
      parama.jLT.setOnItemSelectedListener(new e.3(parama));
      parama.jLQ.setOnItemSelectedListener(new e.2(parama));
      parama.jLR.setOnItemSelectedListener(new e.1(parama));
      parama.b(parama.jLS);
      parama.b(parama.jLT);
      parama.b(parama.jLU);
      parama.b(parama.jLV);
      if (parama.jKX.length == 6) {
        break label2993;
      }
      parama = new IllegalArgumentException("type[] length is not 6");
      AppMethodBeat.o(175354);
      throw parama;
      parama = this.jKP.jLj;
      break;
      parama = this.jKP.jLk;
      break label167;
      label1304:
      parama = this.jKP.jLl;
      break label189;
      label1315:
      if (this.jKP.jKZ != null)
      {
        if (this.jKP.jKZ.get(1) >= 1900) {
          break label478;
        }
        Log.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null");
        this.jKP.jKZ = null;
        break label478;
      }
      if ((this.jKP.jLa == null) || (this.jKP.jLa.get(1) <= 2100)) {
        break label478;
      }
      Log.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null");
      this.jKP.jKZ = null;
      break label478;
      if (i != parama.startYear) {
        break label559;
      }
      if (j > parama.jLW)
      {
        parama.endYear = i;
        parama.jLX = j;
        parama.jLZ = k;
        break label559;
      }
      if ((j != parama.jLW) || (k <= parama.jLY)) {
        break label559;
      }
      parama.endYear = i;
      parama.jLX = j;
      parama.jLZ = k;
      break label559;
      label1482:
      if ((localObject1 != null) && (localObject2 == null))
      {
        i = ((Calendar)localObject1).get(1);
        j = ((Calendar)localObject1).get(2) + 1;
        k = ((Calendar)localObject1).get(5);
        if (i < parama.endYear)
        {
          parama.jLW = j;
          parama.jLY = k;
          parama.startYear = i;
          break label559;
        }
        if (i != parama.endYear) {
          break label559;
        }
        if (j < parama.jLX)
        {
          parama.jLW = j;
          parama.jLY = k;
          parama.startYear = i;
          break label559;
        }
        if ((j != parama.jLX) || (k >= parama.jLZ)) {
          break label559;
        }
        parama.jLW = j;
        parama.jLY = k;
        parama.startYear = i;
        break label559;
      }
      if ((localObject1 == null) || (localObject2 == null)) {
        break label559;
      }
      parama.startYear = ((Calendar)localObject1).get(1);
      parama.endYear = ((Calendar)localObject2).get(1);
      parama.jLW = (((Calendar)localObject1).get(2) + 1);
      parama.jLX = (((Calendar)localObject2).get(2) + 1);
      parama.jLY = ((Calendar)localObject1).get(5);
      parama.jLZ = ((Calendar)localObject2).get(5);
      parama.jMa = ((Calendar)localObject1).get(11);
      parama.jMb = ((Calendar)localObject1).get(12);
      parama.jMc = ((Calendar)localObject2).get(11);
      parama.jMd = ((Calendar)localObject2).get(12);
      break label559;
      label1735:
      if (this.jKP.jKY.getTimeInMillis() <= this.jKP.jLa.getTimeInMillis()) {
        break label627;
      }
      this.jKP.jKY = this.jKP.jLa;
      break label627;
      label1776:
      if (this.jKP.jKZ != null)
      {
        this.jKP.jKY = this.jKP.jKZ;
        break label627;
      }
      if (this.jKP.jLa == null) {
        break label627;
      }
      this.jKP.jKY = this.jKP.jLa;
      break label627;
      label1830:
      i1 = this.jKP.jKY.get(1);
      n = this.jKP.jKY.get(2);
      m = this.jKP.jKY.get(5);
      k = this.jKP.jKY.get(11);
      j = this.jKP.jKY.get(12);
      i = this.jKP.jKY.get(13);
      break label691;
      label1912:
      if (i1 == parama.startYear)
      {
        parama.jLR.setAdapter(new com.tencent.mm.picker.a.c(parama.jLW, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
        parama.jLR.setCurrentItem(n + 1 - parama.jLW);
        break label843;
      }
      if (i1 == parama.endYear)
      {
        parama.jLR.setAdapter(new com.tencent.mm.picker.a.c(1, parama.jLX, new com.tencent.mm.picker.a.b(parama.ctx)));
        parama.jLR.setCurrentItem(n);
        break label843;
      }
      parama.jLR.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new com.tencent.mm.picker.a.b(parama.ctx)));
      parama.jLR.setCurrentItem(n);
      break label843;
      if (parama.jMj.contains(String.valueOf(n + 1)))
      {
        if (parama.jLZ > 30) {
          parama.jLZ = 30;
        }
        parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, parama.jLZ));
        break label949;
      }
      if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
      {
        if (parama.jLZ > 29) {
          parama.jLZ = 29;
        }
        parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, parama.jLZ));
        break label949;
      }
      if (parama.jLZ > 28) {
        parama.jLZ = 28;
      }
      parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, parama.jLZ));
      break label949;
      label2225:
      if ((i1 == parama.startYear) && (n + 1 == parama.jLW))
      {
        if (parama.jMi.contains(String.valueOf(n + 1))) {
          parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, 31));
        }
        for (;;)
        {
          parama.jLS.setCurrentItem(m - parama.jLY);
          break;
          if (parama.jMj.contains(String.valueOf(n + 1))) {
            parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, 30));
          } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
            parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, 29));
          } else {
            parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(parama.jLY, 28));
          }
        }
      }
      if ((i1 == parama.endYear) && (n + 1 == parama.jLX))
      {
        if (parama.jMi.contains(String.valueOf(n + 1)))
        {
          if (parama.jLZ > 31) {
            parama.jLZ = 31;
          }
          parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, parama.jLZ));
        }
        for (;;)
        {
          parama.jLS.setCurrentItem(m - 1);
          break;
          if (parama.jMj.contains(String.valueOf(n + 1)))
          {
            if (parama.jLZ > 30) {
              parama.jLZ = 30;
            }
            parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, parama.jLZ));
          }
          else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0))
          {
            if (parama.jLZ > 29) {
              parama.jLZ = 29;
            }
            parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, parama.jLZ));
          }
          else
          {
            if (parama.jLZ > 28) {
              parama.jLZ = 28;
            }
            parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, parama.jLZ));
          }
        }
      }
      if (parama.jMi.contains(String.valueOf(n + 1))) {
        parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
      }
      for (;;)
      {
        parama.jLS.setCurrentItem(m - 1);
        break;
        if (parama.jMj.contains(String.valueOf(n + 1))) {
          parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
        } else if (((i1 % 4 == 0) && (i1 % 100 != 0)) || (i1 % 400 == 0)) {
          parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
        } else {
          parama.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
        }
      }
      label2807:
      if (j > parama.jMd)
      {
        parama.jLU.setCurrentItem(parama.jMd);
      }
      else
      {
        parama.jLU.setCurrentItem(j);
        continue;
        if (k == parama.jMa)
        {
          parama.jLU.setAdapter(new com.tencent.mm.picker.a.c(parama.jMb, 59));
          if (j < parama.jMb) {
            parama.jLU.setCurrentItem(0);
          } else {
            parama.jLU.setCurrentItem(j - parama.jMb);
          }
        }
        else if (k == parama.jMc)
        {
          parama.jLU.setAdapter(new com.tencent.mm.picker.a.c(0, parama.jMd));
          if (j >= parama.jMd) {
            parama.jLU.setCurrentItem(parama.jMd);
          } else {
            parama.jLU.setCurrentItem(j);
          }
        }
        else
        {
          parama.jLU.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
          parama.jLU.setCurrentItem(j);
        }
      }
    }
    label1411:
    label2993:
    e.aP(parama.bll());
    if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      parama = this.jLJ;
      localObject1 = this.jKP.jLb;
      localObject2 = this.jKP.jLc;
      localObject3 = this.jKP.jLd;
      localObject4 = this.jKP.jLe;
      localObject5 = this.jKP.jLf;
      String str = this.jKP.jLg;
      if (localObject1 == null) {
        break label3364;
      }
      parama.jLQ.setLabel((String)localObject1);
      if (localObject2 == null) {
        break label3387;
      }
      parama.jLR.setLabel((String)localObject2);
      label3112:
      if (localObject3 == null) {
        break label3410;
      }
      parama.jLS.setLabel((String)localObject3);
      label3126:
      if (localObject4 == null) {
        break label3433;
      }
      parama.jLT.setLabel((String)localObject4);
      label3140:
      if (localObject5 == null) {
        break label3456;
      }
      parama.jLU.setLabel((String)localObject5);
      label3154:
      if (str == null) {
        break label3479;
      }
      parama.jLV.setLabel(str);
    }
    for (;;)
    {
      gd(this.jKP.ox);
      this.jLJ.setDividerColor(this.jKP.jKu);
      this.jLJ.jLw = this.jKP.jLw;
      parama = this.jLJ;
      boolean bool = this.jKP.jKV;
      parama.jLQ.setCyclic(bool);
      parama.jLR.setCyclic(bool);
      parama.jLS.setCyclic(bool);
      parama.jLT.setCyclic(bool);
      parama.jLU.setCyclic(bool);
      parama.jLV.setCyclic(bool);
      this.jLJ.jLu = this.jKP.jLu;
      parama = this.jLJ;
      bool = this.jKP.jKn;
      parama.jLS.jKn = bool;
      parama.jLR.jKn = bool;
      parama.jLQ.jKn = bool;
      parama.jLT.jKn = bool;
      parama.jLU.jKn = bool;
      parama.jLV.jKn = bool;
      AppMethodBeat.o(175354);
      return;
      label3364:
      parama.jLQ.setLabel(parama.view.getContext().getString(2131763937));
      break;
      label3387:
      parama.jLR.setLabel(parama.view.getContext().getString(2131763934));
      break label3112;
      label3410:
      parama.jLS.setLabel(parama.view.getContext().getString(2131763931));
      break label3126;
      label3433:
      parama.jLT.setLabel(parama.view.getContext().getString(2131763932));
      break label3140;
      label3456:
      parama.jLU.setLabel(parama.view.getContext().getString(2131763933));
      break label3154;
      label3479:
      parama.jLV.setLabel(parama.view.getContext().getString(2131763935));
    }
  }
  
  public final boolean blf()
  {
    return this.jKP.jLv;
  }
  
  public final void blg()
  {
    AppMethodBeat.i(175356);
    if (this.jKP.jKS != null) {
      try
      {
        Date localDate = e.dateFormat.parse(this.jLJ.getTime());
        this.jKP.jKS.a(localDate);
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
  
  public final View bli()
  {
    AppMethodBeat.i(175357);
    if (this.jLJ.view == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131495932, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131309124);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.jLJ.view = localLinearLayout;
    }
    View localView = this.jLJ.view;
    AppMethodBeat.o(175357);
    return localView;
  }
  
  public final void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175359);
    e locale = this.jLJ;
    locale.jLS.setPadding(0, paramInt1, 0, paramInt2);
    locale.jLT.setPadding(0, paramInt1, 0, paramInt2);
    locale.jLU.setPadding(0, paramInt1, 0, paramInt2);
    locale.jLQ.setPadding(0, paramInt1, 0, paramInt2);
    locale.jLR.setPadding(0, paramInt1, 0, paramInt2);
    locale.jLV.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(175359);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175355);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (((String)paramView.getTag()).equals("submit")) {
      blg();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175355);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175358);
    if (this.jLJ != null)
    {
      e locale = this.jLJ;
      locale.jLS.setDividerHeight(paramFloat);
      locale.jLT.setDividerHeight(paramFloat);
      locale.jLU.setDividerHeight(paramFloat);
      locale.jLQ.setDividerHeight(paramFloat);
      locale.jLR.setDividerHeight(paramFloat);
      locale.jLV.setDividerHeight(paramFloat);
    }
    AppMethodBeat.o(175358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.c
 * JD-Core Version:    0.7.0.1
 */