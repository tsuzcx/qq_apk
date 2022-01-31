package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

final class ExdeviceBindDeviceUI$a
  extends BaseAdapter
{
  private c jAJ;
  List<ExdeviceBindDeviceUI.f> jBD;
  private String jBE;
  private ExdeviceBindDeviceUI.e jBF;
  private String jBG;
  
  public ExdeviceBindDeviceUI$a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
  {
    this.jBE = paramString1;
    this.jBF = parame;
    this.jBG = paramString2;
    this.jBD = new ArrayList();
    paramString1 = new c.a();
    paramString1.ery = R.e.settings_bg;
    this.jAJ = paramString1.OV();
  }
  
  private int BO(String paramString)
  {
    int i = 0;
    while (i < this.jBD.size())
    {
      if (((ExdeviceBindDeviceUI.f)this.jBD.get(i)).getKey().compareTo(paramString) == 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static boolean BP(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public final boolean BM(String paramString)
  {
    return BO(paramString) >= 0;
  }
  
  public final ExdeviceBindDeviceUI.f BN(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jBD.size()) {
        break label78;
      }
      ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.jBD.get(i);
      if (!BP(localf.aMu()))
      {
        localObject = localf;
        if (paramString.equalsIgnoreCase(localf.aMu())) {
          break;
        }
      }
      i += 1;
    }
    label78:
    return null;
  }
  
  public final void aMt()
  {
    int i = 0;
    while (i < this.jBD.size())
    {
      ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.jBD.get(i);
      localf.jBP = c(localf);
      i += 1;
    }
  }
  
  public final boolean b(ExdeviceBindDeviceUI.f paramf)
  {
    if (BO(paramf.getKey()) < 0) {
      return false;
    }
    paramf.jBP = c(paramf);
    return true;
  }
  
  final boolean c(ExdeviceBindDeviceUI.f paramf)
  {
    if (paramf.jBU == null) {}
    do
    {
      return false;
      if (this.jBF != ExdeviceBindDeviceUI.e.jBN) {
        break;
      }
    } while ((paramf.jBU.tkr == null) || (paramf.jBU.tkr.compareTo(this.jBE) != 0) || (paramf.jBU.tkA == null) || (paramf.jBU.tkA.compareTo(this.jBG) != 0));
    do
    {
      return true;
      if (this.jBF != ExdeviceBindDeviceUI.e.jBM) {
        break;
      }
    } while (paramf.jBU.cMX != 0);
    return false;
    Assert.assertTrue(false);
    return false;
  }
  
  final int cT(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < this.jBD.size())
    {
      Object localObject = (ExdeviceBindDeviceUI.f)this.jBD.get(i);
      String str;
      if (((ExdeviceBindDeviceUI.f)localObject).jBT != null)
      {
        str = ((ExdeviceBindDeviceUI.f)localObject).jBT.syI;
        if (((ExdeviceBindDeviceUI.f)localObject).jBT == null) {
          break label132;
        }
        localObject = ((ExdeviceBindDeviceUI.f)localObject).jBT.hQb;
      }
      for (;;)
      {
        if ((BP(str)) || (BP((String)localObject)) || (paramString1.compareTo(str) != 0) || (paramString2.compareTo((String)localObject) != 0)) {
          break label162;
        }
        return i;
        if (((ExdeviceBindDeviceUI.f)localObject).jBQ == ExdeviceBindDeviceUI.b.jBH)
        {
          str = ((ExdeviceBindDeviceUI.f)localObject).jBS.jAa;
          break;
        }
        str = null;
        break;
        label132:
        if (((ExdeviceBindDeviceUI.f)localObject).jBQ == ExdeviceBindDeviceUI.b.jBH) {
          localObject = ((ExdeviceBindDeviceUI.f)localObject).jBS.juM;
        } else {
          localObject = null;
        }
      }
      label162:
      i += 1;
    }
    return -1;
  }
  
  public final int getCount()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jBD.size(); j = k)
    {
      k = j;
      if (((ExdeviceBindDeviceUI.f)this.jBD.get(i)).jBP) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ExdeviceBindDeviceUI.f localf = qt(paramInt);
    ExdeviceBindDeviceUI.a.a locala;
    View localView;
    if (paramView == null)
    {
      locala = new ExdeviceBindDeviceUI.a.a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), R.i.exdevice_bind_device_item, null);
      locala.fhD = ((TextView)localView.findViewById(R.h.nameTV));
      locala.gSx = ((ImageView)localView.findViewById(R.h.iconIV));
      localView.setTag(locala);
    }
    while ((localf == null) || (localf.jBU == null))
    {
      Assert.assertTrue(false);
      return localView;
      locala = (ExdeviceBindDeviceUI.a.a)paramView.getTag();
      localView = paramView;
    }
    Object localObject;
    if (localf.jBQ == ExdeviceBindDeviceUI.b.jBI)
    {
      y.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.jBR.jBK, localf.jBR.btt, localf.jBU.tky });
      localObject = "";
      paramView = localf.jBU.cNb;
      if ((paramView != null) && (paramView.length() >= 4))
      {
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        paramView = localf.jBU.tky + " " + paramView;
        localObject = new SpannableString(paramView);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(R.e.hint_text_color)), localf.jBU.tky.length() + 1, paramView.length(), 17);
        locala.fhD.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      paramView = localf.jBU.kSy;
      if (!BP(paramView)) {
        o.ON().a(paramView, locala.gSx, this.jAJ);
      }
      return localView;
      paramView = (View)localObject;
      if (localf.jBR.btt == null) {
        break;
      }
      paramView = (View)localObject;
      if (localf.jBR.btt.length() < 4) {
        break;
      }
      paramView = localf.jBR.btt;
      paramView = paramView.substring(paramView.length() - 4, paramView.length());
      break;
      if (localf.jBQ == ExdeviceBindDeviceUI.b.jBH)
      {
        localObject = "";
        paramView = localf.jBU.cNb;
        if ((paramView != null) && (paramView.length() >= 4)) {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
        }
        for (;;)
        {
          paramView = localf.jBU.tky + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(R.e.hint_text_color)), localf.jBU.tky.length() + 1, paramView.length(), 17);
          locala.fhD.setText((CharSequence)localObject);
          break;
          paramView = (View)localObject;
          if (localf.jBU.sAE != null)
          {
            paramView = (View)localObject;
            if (localf.jBU.sAE.length() >= 4)
            {
              paramView = localf.jBU.sAE;
              paramView = paramView.substring(paramView.length() - 4, paramView.length());
            }
          }
        }
      }
      Assert.assertTrue(false);
    }
  }
  
  public final ExdeviceBindDeviceUI.f qt(int paramInt)
  {
    int j = -1;
    int i = 0;
    while (i < this.jBD.size())
    {
      int k = j;
      if (((ExdeviceBindDeviceUI.f)this.jBD.get(i)).jBP) {
        k = j + 1;
      }
      if (k == paramInt) {
        return (ExdeviceBindDeviceUI.f)this.jBD.get(i);
      }
      i += 1;
      j = k;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.a
 * JD-Core Version:    0.7.0.1
 */