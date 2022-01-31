package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import junit.framework.Assert;

final class IPCallMyGiftCardUI$a
  extends BaseAdapter
{
  private IPCallMyGiftCardUI nUc;
  asb nUd;
  List<cuy> nxh;
  
  public IPCallMyGiftCardUI$a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
  {
    AppMethodBeat.i(22212);
    this.nxh = null;
    this.nUc = null;
    this.nUd = null;
    Assert.assertTrue(true);
    this.nUc = paramIPCallMyGiftCardUI;
    AppMethodBeat.o(22212);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22213);
    if (this.nxh == null)
    {
      AppMethodBeat.o(22213);
      return 0;
    }
    int i = this.nxh.size();
    AppMethodBeat.o(22213);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(22214);
    if (this.nxh != null)
    {
      Object localObject = this.nxh.get(paramInt);
      AppMethodBeat.o(22214);
      return localObject;
    }
    AppMethodBeat.o(22214);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22215);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.nUc.getSystemService("layout_inflater")).inflate(2130969940, paramViewGroup, false);
      paramViewGroup = new IPCallMyGiftCardUI.a.a(this, (byte)0);
      paramViewGroup.nUe = ((TextView)paramView.findViewById(2131825176));
      paramViewGroup.nUf = ((TextView)paramView.findViewById(2131825177));
      paramViewGroup.nUg = ((TextView)paramView.findViewById(2131825178));
      paramViewGroup.nUh = ((CdnImageView)paramView.findViewById(2131821061));
      paramViewGroup.nUi = ((ImageView)paramView.findViewById(2131825299));
      paramView.setTag(paramViewGroup);
    }
    cuy localcuy;
    for (;;)
    {
      localcuy = (cuy)getItem(paramInt);
      if (localcuy != null) {
        break;
      }
      AppMethodBeat.o(22215);
      return paramView;
      paramViewGroup = (IPCallMyGiftCardUI.a.a)paramView.getTag();
    }
    if (bo.isNullOrNil(localcuy.ydH))
    {
      paramViewGroup.nUe.setVisibility(0);
      paramViewGroup.nUf.setVisibility(0);
      paramViewGroup.nUg.setVisibility(8);
      paramViewGroup.nUe.setText(localcuy.xBK);
      paramViewGroup.nUf.setText(localcuy.ydG);
      a.b.a(paramViewGroup.nUi, "", 0.5F, false);
      if (bo.isNullOrNil(localcuy.nqE)) {
        break label304;
      }
      paramViewGroup.nUh.setVisibility(0);
      paramViewGroup.nUh.setUrl(localcuy.nqE);
      paramViewGroup.nUi.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(22215);
      return paramView;
      paramViewGroup.nUe.setVisibility(8);
      paramViewGroup.nUf.setVisibility(8);
      paramViewGroup.nUg.setVisibility(0);
      paramViewGroup.nUg.setText(localcuy.ydH);
      break;
      label304:
      paramViewGroup.nUi.setVisibility(0);
      paramViewGroup.nUh.setVisibility(4);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.a
 * JD-Core Version:    0.7.0.1
 */