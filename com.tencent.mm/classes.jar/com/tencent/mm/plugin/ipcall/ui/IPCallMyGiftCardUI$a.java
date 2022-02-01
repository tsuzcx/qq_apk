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
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.fgu;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import junit.framework.Assert;

final class IPCallMyGiftCardUI$a
  extends BaseAdapter
{
  private IPCallMyGiftCardUI DWG;
  cfp DWH;
  List<fgu> ctq;
  
  public IPCallMyGiftCardUI$a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
  {
    AppMethodBeat.i(25831);
    this.ctq = null;
    this.DWG = null;
    this.DWH = null;
    Assert.assertTrue(true);
    this.DWG = paramIPCallMyGiftCardUI;
    AppMethodBeat.o(25831);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25832);
    if (this.ctq == null)
    {
      AppMethodBeat.o(25832);
      return 0;
    }
    int i = this.ctq.size();
    AppMethodBeat.o(25832);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25833);
    if (this.ctq != null)
    {
      Object localObject = this.ctq.get(paramInt);
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
      paramView = ((LayoutInflater)this.DWG.getSystemService("layout_inflater")).inflate(R.i.eic, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.DWI = ((TextView)paramView.findViewById(R.h.dCR));
      paramViewGroup.DWJ = ((TextView)paramView.findViewById(R.h.dDC));
      paramViewGroup.DWK = ((TextView)paramView.findViewById(R.h.dGo));
      paramViewGroup.DWL = ((CdnImageView)paramView.findViewById(R.h.header_icon));
      paramViewGroup.DWM = ((ImageView)paramView.findViewById(R.h.dDG));
      paramView.setTag(paramViewGroup);
    }
    fgu localfgu;
    for (;;)
    {
      localfgu = (fgu)getItem(paramInt);
      if (localfgu != null) {
        break;
      }
      AppMethodBeat.o(25834);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if (Util.isNullOrNil(localfgu.UHf))
    {
      paramViewGroup.DWI.setVisibility(0);
      paramViewGroup.DWJ.setVisibility(0);
      paramViewGroup.DWK.setVisibility(8);
      paramViewGroup.DWI.setText(localfgu.TVo);
      paramViewGroup.DWJ.setText(localfgu.UHe);
      a.b.a(paramViewGroup.DWM, "", 0.5F, false);
      if (Util.isNullOrNil(localfgu.CNM)) {
        break label310;
      }
      paramViewGroup.DWL.setVisibility(0);
      paramViewGroup.DWL.setUrl(localfgu.CNM);
      paramViewGroup.DWM.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(25834);
      return paramView;
      paramViewGroup.DWI.setVisibility(8);
      paramViewGroup.DWJ.setVisibility(8);
      paramViewGroup.DWK.setVisibility(0);
      paramViewGroup.DWK.setText(localfgu.UHf);
      break;
      label310:
      paramViewGroup.DWM.setVisibility(0);
      paramViewGroup.DWL.setVisibility(4);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  final class a
  {
    TextView DWI;
    TextView DWJ;
    TextView DWK;
    CdnImageView DWL;
    ImageView DWM;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.a
 * JD-Core Version:    0.7.0.1
 */