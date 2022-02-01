package com.tencent.luggage.game.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.luggage.wxa.a.a.c;
import com.tencent.luggage.wxa.a.a.d;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.aa.a;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.d;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.statusbar.c;

public final class a
  extends aa
{
  private static final int cpM = a.c.app_brand_game_input_panel;
  private static a.b cws;
  public a cwt;
  public WAGamePanelInputEditText cwu;
  private View.OnClickListener cwv;
  
  private a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(130711);
    AppMethodBeat.o(130711);
  }
  
  public static a cv(View paramView)
  {
    AppMethodBeat.i(130712);
    paramView = (a)paramView.getRootView().findViewById(cpM);
    AppMethodBeat.o(130712);
    return paramView;
  }
  
  public static a cw(View paramView)
  {
    AppMethodBeat.i(130713);
    n localn = n.dp(paramView);
    n.dr(paramView);
    Object localObject = aa.dw(paramView);
    if ((localObject != null) && ((((aa)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((aa)localObject).getParent()).removeView((View)localObject);
    }
    localObject = cv(paramView);
    if (localObject == null) {
      if ((paramView instanceof a))
      {
        paramView = (a)paramView;
        localn.dq(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(130713);
      return paramView;
      paramView = new a(paramView.getContext());
      break;
      paramView = (View)localObject;
    }
  }
  
  public static void setGameInputEditBarLayoutFactory(a.b paramb)
  {
    cws = paramb;
  }
  
  public final int Qh()
  {
    return cpM;
  }
  
  public final void Qi()
  {
    AppMethodBeat.i(130714);
    cw(this);
    AppMethodBeat.o(130714);
  }
  
  public final void Qj()
  {
    AppMethodBeat.i(130715);
    this.cwt.setIsHide(false);
    AppMethodBeat.o(130715);
  }
  
  public final void Qk()
  {
    int k = 0;
    AppMethodBeat.i(130716);
    View localView = this.cwt.Qn();
    int i;
    if ((this.cwu.getInputType() & 0x20000) > 0)
    {
      i = 1;
      j = k;
      if (i == 0) {
        if ((this.rwL == null) || (this.rwL.getVisibility() != 0)) {
          break label73;
        }
      }
    }
    label73:
    for (int j = k;; j = 8)
    {
      localView.setVisibility(j);
      AppMethodBeat.o(130716);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(247221);
    super.ca(paramBoolean);
    if (!paramBoolean) {
      c.bA(this.rwQ.getHostActivity()).hXX();
    }
    AppMethodBeat.o(247221);
  }
  
  public final void ce(boolean paramBoolean)
  {
    AppMethodBeat.i(247223);
    if ((coY()) && (this.rwJ != null)) {
      this.rwJ.ce(paramBoolean);
    }
    AppMethodBeat.o(247223);
  }
  
  public final WAGamePanelInputEditText getAttachedEditText()
  {
    AppMethodBeat.i(130717);
    WAGamePanelInputEditText localWAGamePanelInputEditText = (WAGamePanelInputEditText)super.getAttachedEditText();
    AppMethodBeat.o(130717);
    return localWAGamePanelInputEditText;
  }
  
  public final void iF(int paramInt)
  {
    AppMethodBeat.i(247220);
    int i = paramInt;
    if (paramInt > 0)
    {
      i = paramInt;
      if (2 == ((u)n.dp(this).getOnLayoutListener()).rvS)
      {
        Object localObject = this.rwQ.getHostActivity();
        i = paramInt;
        if (x.eq((Context)localObject))
        {
          i = paramInt;
          if (Build.VERSION.SDK_INT <= 29)
          {
            localObject = as.bu((Activity)localObject);
            i = paramInt;
            if (localObject != null)
            {
              Log.d("MicroMsg.WAGameInputPanel", "refreshHeight height:%d, append insetBottom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((WindowInsets)localObject).getStableInsetBottom()) });
              i = paramInt + ((WindowInsets)localObject).getStableInsetBottom();
            }
          }
        }
      }
    }
    super.iF(i);
    AppMethodBeat.o(247220);
  }
  
  public final void setOnConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cwv = paramOnClickListener;
  }
  
  public final void setOnEmoticonOperationListener(d paramd)
  {
    AppMethodBeat.i(247224);
    if (this.rwJ != null) {
      this.rwJ.setOnEmoticonOperationListener(paramd);
    }
    AppMethodBeat.o(247224);
  }
  
  public final void show()
  {
    AppMethodBeat.i(130718);
    if (this.rwQ.getHostActivity() != null) {}
    try
    {
      localu = (u)n.dp(this).getOnLayoutListener();
      Activity localActivity = this.rwQ.getHostActivity();
      if ((Build.VERSION.SDK_INT < 24) || (localActivity == null) || (!localActivity.isInMultiWindowMode())) {
        break label149;
      }
      i = 1;
      if (i == 0)
      {
        localActivity = this.rwQ.getHostActivity();
        if ((!(localActivity instanceof Activity)) || (localActivity.getResources().getConfiguration().orientation != 2)) {
          break label154;
        }
        i = 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        u localu;
        int i;
        label149:
        label154:
        Log.e("MicroMsg.WAGameInputPanel", "show() fix SoftInputMode for game, get exception:%s", new Object[] { localException });
        continue;
        if (i == 0) {}
      }
    }
    this.rwQ.getHostActivity().getWindow().setSoftInputMode(16);
    localu.DP(1);
    for (;;)
    {
      this.rwP = this.cwu;
      this.cwu.requestFocus();
      super.show();
      AppMethodBeat.o(130718);
      return;
      i = 0;
      break;
      i = 0;
      break label204;
      this.rwQ.getHostActivity().getWindow().setSoftInputMode(48);
      localu.DP(2);
    }
  }
  
  public static final class a
    extends FrameLayout
    implements aa.a
  {
    public View cwy;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(130708);
      if (a.Qm() != null) {
        a.Qm().d(this);
      }
      for (;;)
      {
        ((Button)findViewById(a.c.game_edit_send)).setText(a.e.appbrand_game_input_confirm);
        setClickable(true);
        AppMethodBeat.o(130708);
        return;
        LayoutInflater.from(paramContext).inflate(a.d.app_brand_game_input_panel_edit_bar, this, true);
      }
    }
    
    public final View Qn()
    {
      AppMethodBeat.i(130707);
      if (this.cwy == null) {
        this.cwy = findViewById(a.c.game_edit_send);
      }
      View localView = this.cwy;
      AppMethodBeat.o(130707);
      return localView;
    }
    
    public final void setIsHide(boolean paramBoolean)
    {
      AppMethodBeat.i(130709);
      if (paramBoolean) {}
      for (int i = 8;; i = 0)
      {
        setVisibility(i);
        AppMethodBeat.o(130709);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */