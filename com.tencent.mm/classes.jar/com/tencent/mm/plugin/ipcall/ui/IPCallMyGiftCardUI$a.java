package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.gdg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import junit.framework.Assert;

final class IPCallMyGiftCardUI$a
  extends BaseAdapter
{
  private IPCallMyGiftCardUI JNP;
  cvs JNQ;
  List<gdg> ell;
  
  public IPCallMyGiftCardUI$a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
  {
    AppMethodBeat.i(25831);
    this.ell = null;
    this.JNP = null;
    this.JNQ = null;
    Assert.assertTrue(true);
    this.JNP = paramIPCallMyGiftCardUI;
    AppMethodBeat.o(25831);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25832);
    if (this.ell == null)
    {
      AppMethodBeat.o(25832);
      return 0;
    }
    int i = this.ell.size();
    AppMethodBeat.o(25832);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25833);
    if (this.ell != null)
    {
      Object localObject = this.ell.get(paramInt);
      AppMethodBeat.o(25833);
      return localObject;
    }
    AppMethodBeat.o(25833);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25834);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.JNP.getSystemService("layout_inflater")).inflate(R.i.gkX, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.JNR = ((TextView)paramView.findViewById(R.h.fDJ));
      paramViewGroup.JNS = ((TextView)paramView.findViewById(R.h.fEt));
      paramViewGroup.JNT = ((TextView)paramView.findViewById(R.h.fHu));
      paramViewGroup.JNU = ((CdnImageView)paramView.findViewById(R.h.header_icon));
      paramViewGroup.JNV = ((ImageView)paramView.findViewById(R.h.fEx));
      paramView.setTag(paramViewGroup);
    }
    gdg localgdg;
    for (;;)
    {
      localgdg = (gdg)getItem(paramInt);
      if (localgdg != null) {
        break;
      }
      AppMethodBeat.o(25834);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if (Util.isNullOrNil(localgdg.acbo))
    {
      paramViewGroup.JNR.setVisibility(0);
      paramViewGroup.JNS.setVisibility(0);
      paramViewGroup.JNT.setVisibility(8);
      paramViewGroup.JNR.setText(localgdg.ablY);
      paramViewGroup.JNS.setText(localgdg.acbn);
      a.b.a(paramViewGroup.JNV, "", 0.5F, false);
      if (Util.isNullOrNil(localgdg.IHW)) {
        break label310;
      }
      paramViewGroup.JNU.setVisibility(0);
      paramViewGroup.JNU.setUrl(localgdg.IHW);
      paramViewGroup.JNV.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(25834);
      return paramView;
      paramViewGroup.JNR.setVisibility(8);
      paramViewGroup.JNS.setVisibility(8);
      paramViewGroup.JNT.setVisibility(0);
      paramViewGroup.JNT.setText(localgdg.acbo);
      break;
      label310:
      paramViewGroup.JNV.setVisibility(0);
      paramViewGroup.JNU.setVisibility(4);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  final class a
  {
    TextView JNR;
    TextView JNS;
    TextView JNT;
    CdnImageView JNU;
    ImageView JNV;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.a
 * JD-Core Version:    0.7.0.1
 */