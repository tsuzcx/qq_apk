package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

final class MallFunctionSettingsUI$a
  extends BaseAdapter
{
  private MallFunctionSettingsUI$a(MallFunctionSettingsUI paramMallFunctionSettingsUI) {}
  
  private MallFunctionSettingsUI.b yN(int paramInt)
  {
    AppMethodBeat.i(43154);
    MallFunctionSettingsUI.b localb = (MallFunctionSettingsUI.b)MallFunctionSettingsUI.b(this.ozh).get(paramInt);
    AppMethodBeat.o(43154);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43153);
    int i = MallFunctionSettingsUI.b(this.ozh).size();
    AppMethodBeat.o(43153);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(43155);
    paramInt = ((MallFunctionSettingsUI.b)MallFunctionSettingsUI.b(this.ozh).get(paramInt)).type;
    AppMethodBeat.o(43155);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43156);
    Object localObject1 = paramView;
    Object localObject2;
    if (paramView == null)
    {
      int i = getItemViewType(paramInt);
      localObject1 = new MallFunctionSettingsUI.c(this.ozh, (byte)0);
      if (i == 1)
      {
        paramView = LayoutInflater.from(this.ozh.getContext()).inflate(2130970075, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).nJN = ((CdnImageView)paramView.findViewById(2131825918));
        ((MallFunctionSettingsUI.c)localObject1).iJG = ((TextView)paramView.findViewById(2131825919));
        ((MallFunctionSettingsUI.c)localObject1).kPB = ((TextView)paramView.findViewById(2131825920));
        ((MallFunctionSettingsUI.c)localObject1).ozl = ((MMSwitchBtn)paramView.findViewById(2131825921));
        ((MallFunctionSettingsUI.c)localObject1).lNu = paramView.findViewById(2131825923);
        ((MallFunctionSettingsUI.c)localObject1).ozm = paramView.findViewById(2131825922);
        ((MallFunctionSettingsUI.c)localObject1).iSs = ((ViewGroup)paramView);
        ((MallFunctionSettingsUI.c)localObject1).nJN.setUseSdcardCache(true);
        paramView.setTag(localObject1);
        localObject1 = paramView;
      }
    }
    else
    {
      paramView = yN(paramInt);
      paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
      if (paramView.type != 1) {
        break label562;
      }
      localObject2 = paramView.ozj;
      if (((bkw)localObject2).xzy != null) {
        paramViewGroup.nJN.setUrl(((bkw)localObject2).xzy.dqj());
      }
      if (((bkw)localObject2).xzx != null) {
        paramViewGroup.iJG.setText(((bkw)localObject2).xzx.dqj());
      }
      if ((((bkw)localObject2).xzz == null) || (bo.isNullOrNil(((bkw)localObject2).xzz.dqj()))) {
        break label440;
      }
      paramViewGroup.kPB.setText(((bkw)localObject2).xzz.dqj());
      paramViewGroup.kPB.setVisibility(0);
      label282:
      if (((bkw)localObject2).jJS != 0) {
        break label452;
      }
      paramViewGroup.ozl.setCheck(true);
      paramViewGroup.ozl.setEnabled(true);
      paramViewGroup.iJG.setTextColor(paramViewGroup.ozh.getContext().getResources().getColor(2131689765));
      paramViewGroup.ozm.setVisibility(8);
      label337:
      paramViewGroup.ozl.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (bkw)localObject2));
      localObject2 = (LinearLayout.LayoutParams)paramViewGroup.lNu.getLayoutParams();
      if (!paramView.ozk) {
        break label547;
      }
      ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
      label379:
      paramViewGroup.lNu.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(43156);
      return localObject1;
      paramView = LayoutInflater.from(this.ozh.getContext()).inflate(2130970076, paramViewGroup, false);
      ((MallFunctionSettingsUI.c)localObject1).iJG = ((TextView)paramView.findViewById(2131825924));
      ((MallFunctionSettingsUI.c)localObject1).iSs = ((ViewGroup)paramView);
      break;
      label440:
      paramViewGroup.kPB.setVisibility(8);
      break label282;
      label452:
      if (((bkw)localObject2).jJS == 1)
      {
        paramViewGroup.ozl.setCheck(false);
        paramViewGroup.ozl.setEnabled(true);
        paramViewGroup.iJG.setTextColor(paramViewGroup.ozh.getContext().getResources().getColor(2131689765));
        paramViewGroup.ozm.setVisibility(8);
        break label337;
      }
      if (((bkw)localObject2).jJS != 2) {
        break label337;
      }
      paramViewGroup.ozl.setCheck(false);
      paramViewGroup.ozl.setEnabled(false);
      paramViewGroup.ozm.setVisibility(0);
      break label337;
      label547:
      ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.ozh);
      break label379;
      label562:
      if (paramView.type == 0) {
        paramViewGroup.iJG.setText(paramView.title);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI.a
 * JD-Core Version:    0.7.0.1
 */