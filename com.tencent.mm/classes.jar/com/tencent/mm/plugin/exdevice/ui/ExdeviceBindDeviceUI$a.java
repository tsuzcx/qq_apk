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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

final class ExdeviceBindDeviceUI$a
  extends BaseAdapter
{
  private c lKi;
  List<ExdeviceBindDeviceUI.f> lLc;
  private String lLd;
  private ExdeviceBindDeviceUI.e lLe;
  private String lLf;
  
  public ExdeviceBindDeviceUI$a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
  {
    AppMethodBeat.i(19837);
    this.lLd = paramString1;
    this.lLe = parame;
    this.lLf = paramString2;
    this.lLc = new ArrayList();
    paramString1 = new c.a();
    paramString1.eOa = 2131690446;
    this.lKi = paramString1.ahY();
    AppMethodBeat.o(19837);
  }
  
  private int LQ(String paramString)
  {
    AppMethodBeat.i(19845);
    int i = 0;
    while (i < this.lLc.size())
    {
      if (((ExdeviceBindDeviceUI.f)this.lLc.get(i)).getKey().compareTo(paramString) == 0)
      {
        AppMethodBeat.o(19845);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(19845);
    return -1;
  }
  
  private static boolean LR(String paramString)
  {
    AppMethodBeat.i(19848);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(19848);
      return true;
    }
    AppMethodBeat.o(19848);
    return false;
  }
  
  public final boolean LO(String paramString)
  {
    AppMethodBeat.i(19840);
    if (LQ(paramString) >= 0)
    {
      AppMethodBeat.o(19840);
      return true;
    }
    AppMethodBeat.o(19840);
    return false;
  }
  
  public final ExdeviceBindDeviceUI.f LP(String paramString)
  {
    AppMethodBeat.i(19841);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(19841);
      return null;
    }
    int i = 0;
    while (i < this.lLc.size())
    {
      ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.lLc.get(i);
      if ((!LR(localf.bqH())) && (paramString.equalsIgnoreCase(localf.bqH())))
      {
        AppMethodBeat.o(19841);
        return localf;
      }
      i += 1;
    }
    AppMethodBeat.o(19841);
    return null;
  }
  
  public final boolean b(ExdeviceBindDeviceUI.f paramf)
  {
    AppMethodBeat.i(19839);
    if (LQ(paramf.getKey()) < 0)
    {
      AppMethodBeat.o(19839);
      return false;
    }
    paramf.lLo = c(paramf);
    AppMethodBeat.o(19839);
    return true;
  }
  
  final void bqG()
  {
    AppMethodBeat.i(19838);
    int i = 0;
    while (i < this.lLc.size())
    {
      ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.lLc.get(i);
      localf.lLo = c(localf);
      i += 1;
    }
    AppMethodBeat.o(19838);
  }
  
  final boolean c(ExdeviceBindDeviceUI.f paramf)
  {
    AppMethodBeat.i(19847);
    if (paramf.lLt == null)
    {
      AppMethodBeat.o(19847);
      return false;
    }
    if (this.lLe == ExdeviceBindDeviceUI.e.lLm)
    {
      if ((paramf.lLt.xji == null) || (paramf.lLt.xji.compareTo(this.lLd) != 0))
      {
        AppMethodBeat.o(19847);
        return false;
      }
      if ((paramf.lLt.xjr == null) || (paramf.lLt.xjr.compareTo(this.lLf) != 0))
      {
        AppMethodBeat.o(19847);
        return false;
      }
    }
    else if (this.lLe == ExdeviceBindDeviceUI.e.lLl)
    {
      if (paramf.lLt.dCN == 0)
      {
        AppMethodBeat.o(19847);
        return false;
      }
    }
    else
    {
      Assert.assertTrue(false);
      AppMethodBeat.o(19847);
      return false;
    }
    AppMethodBeat.o(19847);
    return true;
  }
  
  final int dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19846);
    int i = 0;
    while (i < this.lLc.size())
    {
      Object localObject = (ExdeviceBindDeviceUI.f)this.lLc.get(i);
      String str;
      if (((ExdeviceBindDeviceUI.f)localObject).lLs != null)
      {
        str = ((ExdeviceBindDeviceUI.f)localObject).lLs.wsq;
        if (((ExdeviceBindDeviceUI.f)localObject).lLs == null) {
          break label144;
        }
        localObject = ((ExdeviceBindDeviceUI.f)localObject).lLs.jJD;
      }
      for (;;)
      {
        if ((LR(str)) || (LR((String)localObject)) || (paramString1.compareTo(str) != 0) || (paramString2.compareTo((String)localObject) != 0)) {
          break label174;
        }
        AppMethodBeat.o(19846);
        return i;
        if (((ExdeviceBindDeviceUI.f)localObject).lLp == ExdeviceBindDeviceUI.b.lLg)
        {
          str = ((ExdeviceBindDeviceUI.f)localObject).lLr.lJz;
          break;
        }
        str = null;
        break;
        label144:
        if (((ExdeviceBindDeviceUI.f)localObject).lLp == ExdeviceBindDeviceUI.b.lLg) {
          localObject = ((ExdeviceBindDeviceUI.f)localObject).lLr.lEl;
        } else {
          localObject = null;
        }
      }
      label174:
      i += 1;
    }
    AppMethodBeat.o(19846);
    return -1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(19842);
    int i = 0;
    int k;
    for (int j = 0; i < this.lLc.size(); j = k)
    {
      k = j;
      if (((ExdeviceBindDeviceUI.f)this.lLc.get(i)).lLo) {
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(19842);
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(19844);
    ExdeviceBindDeviceUI.f localf = va(paramInt);
    ExdeviceBindDeviceUI.a.a locala;
    View localView;
    if (paramView == null)
    {
      locala = new ExdeviceBindDeviceUI.a.a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2130969445, null);
      locala.gzk = ((TextView)localView.findViewById(2131823741));
      locala.ivs = ((ImageView)localView.findViewById(2131823740));
      localView.setTag(locala);
    }
    while ((localf == null) || (localf.lLt == null))
    {
      Assert.assertTrue(false);
      AppMethodBeat.o(19844);
      return localView;
      locala = (ExdeviceBindDeviceUI.a.a)paramView.getTag();
      localView = paramView;
    }
    Object localObject;
    if (localf.lLp == ExdeviceBindDeviceUI.b.lLh)
    {
      ab.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.lLq.lLj, localf.lLq.bUD, localf.lLt.xjp });
      localObject = "";
      paramView = localf.lLt.dCR;
      if ((paramView != null) && (paramView.length() >= 4))
      {
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        paramView = localf.lLt.xjp + " " + paramView;
        localObject = new SpannableString(paramView);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131690168)), localf.lLt.xjp.length() + 1, paramView.length(), 17);
        locala.gzk.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      paramView = localf.lLt.IconUrl;
      if (!LR(paramView)) {
        o.ahG().a(paramView, locala.ivs, this.lKi);
      }
      AppMethodBeat.o(19844);
      return localView;
      paramView = (View)localObject;
      if (localf.lLq.bUD == null) {
        break;
      }
      paramView = (View)localObject;
      if (localf.lLq.bUD.length() < 4) {
        break;
      }
      paramView = localf.lLq.bUD;
      paramView = paramView.substring(paramView.length() - 4, paramView.length());
      break;
      if (localf.lLp == ExdeviceBindDeviceUI.b.lLg)
      {
        localObject = "";
        paramView = localf.lLt.dCR;
        if ((paramView != null) && (paramView.length() >= 4)) {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
        }
        for (;;)
        {
          paramView = localf.lLt.xjp + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131690168)), localf.lLt.xjp.length() + 1, paramView.length(), 17);
          locala.gzk.setText((CharSequence)localObject);
          break;
          paramView = (View)localObject;
          if (localf.lLt.wuT != null)
          {
            paramView = (View)localObject;
            if (localf.lLt.wuT.length() >= 4)
            {
              paramView = localf.lLt.wuT;
              paramView = paramView.substring(paramView.length() - 4, paramView.length());
            }
          }
        }
      }
      Assert.assertTrue(false);
    }
  }
  
  public final ExdeviceBindDeviceUI.f va(int paramInt)
  {
    AppMethodBeat.i(19843);
    int j = -1;
    int i = 0;
    while (i < this.lLc.size())
    {
      int k = j;
      if (((ExdeviceBindDeviceUI.f)this.lLc.get(i)).lLo) {
        k = j + 1;
      }
      if (k == paramInt)
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.lLc.get(i);
        AppMethodBeat.o(19843);
        return localf;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(19843);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.a
 * JD-Core Version:    0.7.0.1
 */