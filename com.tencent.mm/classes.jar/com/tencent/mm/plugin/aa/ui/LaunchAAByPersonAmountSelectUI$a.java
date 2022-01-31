package com.tencent.mm.plugin.aa.ui;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$a
  extends BaseAdapter
{
  List<LaunchAAByPersonAmountSelectUI.b> dataList;
  
  public LaunchAAByPersonAmountSelectUI$a(List<String> paramList, Map<String, Double> paramMap)
  {
    AppMethodBeat.i(40799);
    this.dataList = null;
    this.dataList = new ArrayList();
    paramMap = paramMap.iterator();
    if (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      LaunchAAByPersonAmountSelectUI.b localb = new LaunchAAByPersonAmountSelectUI.b(paramList, (byte)0);
      localb.username = str;
      Object localObject;
      if ((localObject != null) && (localObject.containsKey(str))) {}
      for (localb.gqE = paramList.getString(2131296341, new Object[] { localObject.get(str) });; localb.gqE = "")
      {
        this.dataList.add(localb);
        break;
      }
    }
    AppMethodBeat.o(40799);
  }
  
  private LaunchAAByPersonAmountSelectUI.b mN(int paramInt)
  {
    AppMethodBeat.i(40801);
    LaunchAAByPersonAmountSelectUI.b localb = (LaunchAAByPersonAmountSelectUI.b)this.dataList.get(paramInt);
    AppMethodBeat.o(40801);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40800);
    int i = this.dataList.size();
    AppMethodBeat.o(40800);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(40802);
    LaunchAAByPersonAmountSelectUI.b localb = mN(paramInt);
    Object localObject = paramView;
    if (localb != null)
    {
      localObject = paramView;
      if (!bo.isNullOrNil(localb.username))
      {
        View localView = paramView;
        if (paramView == null)
        {
          localView = w.hM(this.gqx).inflate(2130969964, paramViewGroup, false);
          paramView = new LaunchAAByPersonAmountSelectUI.a.a(this, (byte)0);
          paramView.ehv = ((ImageView)localView.findViewById(2131823820));
          paramView.gqe = ((TextView)localView.findViewById(2131821594));
          paramView.gqf = ((WalletFormView)localView.findViewById(2131825366));
          paramView.gqD = new LaunchAAByPersonAmountSelectUI.c(this.gqx, localb.username);
          paramView.gqf.a(paramView.gqD);
          paramView.ehv.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.a.1(this, paramView));
          paramView.gqe.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.a.2(this, paramView));
          localView.setTag(paramView);
          this.gqx.setEditFocusListener(paramView.gqf, 2, false, true);
        }
        paramView = (LaunchAAByPersonAmountSelectUI.a.a)localView.getTag();
        if (!bo.isNullOrNil(localb.username))
        {
          paramView.gqD.username = localb.username;
          a.b.c(paramView.ehv, localb.username);
          paramView.gqe.setText(j.b(this.gqx.getContext(), ((b)g.E(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.n(this.gqx)), paramView.gqe.getTextSize()));
        }
        localObject = localView;
        if (localb.gqE != null)
        {
          localObject = localView;
          if (paramView.gqf.getText() != null)
          {
            localObject = localView;
            if (!localb.gqE.equals(paramView.gqf.getText().toLowerCase()))
            {
              paramViewGroup = paramView.gqf;
              localObject = paramView.gqD;
              if (paramViewGroup.AZe != null) {
                paramViewGroup.AZe.removeTextChangedListener((TextWatcher)localObject);
              }
              paramView.gqf.setText(localb.gqE);
              paramView.gqf.a(paramView.gqD);
              localObject = localView;
            }
          }
        }
      }
    }
    AppMethodBeat.o(40802);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a
 * JD-Core Version:    0.7.0.1
 */