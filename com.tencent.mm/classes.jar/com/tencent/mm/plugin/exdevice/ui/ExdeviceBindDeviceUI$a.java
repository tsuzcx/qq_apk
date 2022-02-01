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
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

final class ExdeviceBindDeviceUI$a
  extends BaseAdapter
{
  private c paS;
  List<ExdeviceBindDeviceUI.f> pbM;
  private String pbN;
  private ExdeviceBindDeviceUI.e pbO;
  private String pbP;
  
  public ExdeviceBindDeviceUI$a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
  {
    AppMethodBeat.i(23905);
    this.pbN = paramString1;
    this.pbO = parame;
    this.pbP = paramString2;
    this.pbM = new ArrayList();
    paramString1 = new c.a();
    paramString1.hki = 2131100860;
    this.paS = paramString1.azc();
    AppMethodBeat.o(23905);
  }
  
  private int UZ(String paramString)
  {
    AppMethodBeat.i(23913);
    int i = 0;
    while (i < this.pbM.size())
    {
      if (((ExdeviceBindDeviceUI.f)this.pbM.get(i)).getKey().compareTo(paramString) == 0)
      {
        AppMethodBeat.o(23913);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(23913);
    return -1;
  }
  
  private static boolean Va(String paramString)
  {
    AppMethodBeat.i(23916);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(23916);
      return true;
    }
    AppMethodBeat.o(23916);
    return false;
  }
  
  public final ExdeviceBindDeviceUI.f Be(int paramInt)
  {
    AppMethodBeat.i(23911);
    int j = -1;
    int i = 0;
    while (i < this.pbM.size())
    {
      int k = j;
      if (((ExdeviceBindDeviceUI.f)this.pbM.get(i)).pbY) {
        k = j + 1;
      }
      if (k == paramInt)
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.pbM.get(i);
        AppMethodBeat.o(23911);
        return localf;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(23911);
    return null;
  }
  
  public final boolean UX(String paramString)
  {
    AppMethodBeat.i(23908);
    if (UZ(paramString) >= 0)
    {
      AppMethodBeat.o(23908);
      return true;
    }
    AppMethodBeat.o(23908);
    return false;
  }
  
  public final ExdeviceBindDeviceUI.f UY(String paramString)
  {
    AppMethodBeat.i(23909);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(23909);
      return null;
    }
    int i = 0;
    while (i < this.pbM.size())
    {
      ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.pbM.get(i);
      if ((!Va(localf.cap())) && (paramString.equalsIgnoreCase(localf.cap())))
      {
        AppMethodBeat.o(23909);
        return localf;
      }
      i += 1;
    }
    AppMethodBeat.o(23909);
    return null;
  }
  
  public final boolean b(ExdeviceBindDeviceUI.f paramf)
  {
    AppMethodBeat.i(23907);
    if (UZ(paramf.getKey()) < 0)
    {
      AppMethodBeat.o(23907);
      return false;
    }
    paramf.pbY = c(paramf);
    AppMethodBeat.o(23907);
    return true;
  }
  
  final boolean c(ExdeviceBindDeviceUI.f paramf)
  {
    AppMethodBeat.i(23915);
    if (paramf.pcd == null)
    {
      AppMethodBeat.o(23915);
      return false;
    }
    if (this.pbO == ExdeviceBindDeviceUI.e.pbW)
    {
      if ((paramf.pcd.DCD == null) || (paramf.pcd.DCD.compareTo(this.pbN) != 0))
      {
        AppMethodBeat.o(23915);
        return false;
      }
      if ((paramf.pcd.DCM == null) || (paramf.pcd.DCM.compareTo(this.pbP) != 0))
      {
        AppMethodBeat.o(23915);
        return false;
      }
    }
    else if (this.pbO == ExdeviceBindDeviceUI.e.pbV)
    {
      if (paramf.pcd.eKr == 0)
      {
        AppMethodBeat.o(23915);
        return false;
      }
    }
    else
    {
      Assert.assertTrue(false);
      AppMethodBeat.o(23915);
      return false;
    }
    AppMethodBeat.o(23915);
    return true;
  }
  
  final void cao()
  {
    AppMethodBeat.i(23906);
    int i = 0;
    while (i < this.pbM.size())
    {
      ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.pbM.get(i);
      localf.pbY = c(localf);
      i += 1;
    }
    AppMethodBeat.o(23906);
  }
  
  final int fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23914);
    int i = 0;
    while (i < this.pbM.size())
    {
      Object localObject = (ExdeviceBindDeviceUI.f)this.pbM.get(i);
      String str;
      if (((ExdeviceBindDeviceUI.f)localObject).pcc != null)
      {
        str = ((ExdeviceBindDeviceUI.f)localObject).pcc.CBS;
        if (((ExdeviceBindDeviceUI.f)localObject).pcc == null) {
          break label144;
        }
        localObject = ((ExdeviceBindDeviceUI.f)localObject).pcc.mAT;
      }
      for (;;)
      {
        if ((Va(str)) || (Va((String)localObject)) || (paramString1.compareTo(str) != 0) || (paramString2.compareTo((String)localObject) != 0)) {
          break label174;
        }
        AppMethodBeat.o(23914);
        return i;
        if (((ExdeviceBindDeviceUI.f)localObject).pbZ == ExdeviceBindDeviceUI.b.pbQ)
        {
          str = ((ExdeviceBindDeviceUI.f)localObject).pcb.mDeviceType;
          break;
        }
        str = null;
        break;
        label144:
        if (((ExdeviceBindDeviceUI.f)localObject).pbZ == ExdeviceBindDeviceUI.b.pbQ) {
          localObject = ((ExdeviceBindDeviceUI.f)localObject).pcb.oUX;
        } else {
          localObject = null;
        }
      }
      label174:
      i += 1;
    }
    AppMethodBeat.o(23914);
    return -1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23910);
    int i = 0;
    int k;
    for (int j = 0; i < this.pbM.size(); j = k)
    {
      k = j;
      if (((ExdeviceBindDeviceUI.f)this.pbM.get(i)).pbY) {
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(23910);
    return j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23912);
    ExdeviceBindDeviceUI.f localf = Be(paramInt);
    a locala;
    View localView;
    if (paramView == null)
    {
      locala = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2131493857, null);
      locala.imt = ((TextView)localView.findViewById(2131302656));
      locala.kXS = ((ImageView)localView.findViewById(2131300880));
      localView.setTag(locala);
    }
    while ((localf == null) || (localf.pcd == null))
    {
      Assert.assertTrue(false);
      AppMethodBeat.o(23912);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
    }
    Object localObject;
    if (localf.pbZ == ExdeviceBindDeviceUI.b.pbR)
    {
      ad.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.pca.pbT, localf.pca.cGn, localf.pcd.DCK });
      localObject = "";
      paramView = localf.pcd.eKv;
      if ((paramView != null) && (paramView.length() >= 4))
      {
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        paramView = localf.pcd.DCK + " " + paramView;
        localObject = new SpannableString(paramView);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100490)), localf.pcd.DCK.length() + 1, paramView.length(), 17);
        locala.imt.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      paramView = localf.pcd.IconUrl;
      if (!Va(paramView)) {
        o.ayJ().a(paramView, locala.kXS, this.paS);
      }
      AppMethodBeat.o(23912);
      return localView;
      paramView = (View)localObject;
      if (localf.pca.cGn == null) {
        break;
      }
      paramView = (View)localObject;
      if (localf.pca.cGn.length() < 4) {
        break;
      }
      paramView = localf.pca.cGn;
      paramView = paramView.substring(paramView.length() - 4, paramView.length());
      break;
      if (localf.pbZ == ExdeviceBindDeviceUI.b.pbQ)
      {
        localObject = "";
        paramView = localf.pcd.eKv;
        if ((paramView != null) && (paramView.length() >= 4)) {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
        }
        for (;;)
        {
          paramView = localf.pcd.DCK + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100490)), localf.pcd.DCK.length() + 1, paramView.length(), 17);
          locala.imt.setText((CharSequence)localObject);
          break;
          paramView = (View)localObject;
          if (localf.pcd.CEQ != null)
          {
            paramView = (View)localObject;
            if (localf.pcd.CEQ.length() >= 4)
            {
              paramView = localf.pcd.CEQ;
              paramView = paramView.substring(paramView.length() - 4, paramView.length());
            }
          }
        }
      }
      Assert.assertTrue(false);
    }
  }
  
  static final class a
  {
    TextView imt;
    ImageView kXS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.a
 * JD-Core Version:    0.7.0.1
 */