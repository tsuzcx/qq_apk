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
import com.tencent.luggage.wxa.a.a.d;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.luggage.wxa.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.aa.a;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
import com.tencent.mm.plugin.appbrand.widget.input.d.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.statusbar.c;

public final class a
  extends aa
{
  private static final int ehD = a.d.app_brand_game_input_panel;
  private static a.b eor;
  private static boolean eot = false;
  public a eos;
  public WAGamePanelInputEditText eou;
  private View.OnClickListener eov;
  
  private a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, paramBoolean);
  }
  
  public static a cQ(View paramView)
  {
    AppMethodBeat.i(130712);
    paramView = (a)paramView.getRootView().findViewById(ehD);
    AppMethodBeat.o(130712);
    return paramView;
  }
  
  public static a l(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(220159);
    n localn = n.ed(paramView);
    n.ef(paramView);
    Object localObject = aa.ek(paramView);
    if ((localObject != null) && ((((aa)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((aa)localObject).getParent()).removeView((View)localObject);
    }
    a locala = cQ(paramView);
    localObject = locala;
    if (eot != paramBoolean)
    {
      localObject = locala;
      if (locala != null)
      {
        localn.removeView(locala);
        localObject = null;
      }
    }
    eot = paramBoolean;
    if (localObject == null) {
      if ((paramView instanceof a))
      {
        paramView = (a)paramView;
        localn.ee(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220159);
      return paramView;
      paramView = new a(paramView.getContext(), paramBoolean);
      break;
      paramView = (View)localObject;
    }
  }
  
  public static void setGameInputEditBarLayoutFactory(a.b paramb)
  {
    eor = paramb;
  }
  
  public final int aqr()
  {
    return ehD;
  }
  
  public final void aqs()
  {
    AppMethodBeat.i(130714);
    l(this, eot);
    AppMethodBeat.o(130714);
  }
  
  public final void aqt()
  {
    AppMethodBeat.i(130715);
    this.eos.setIsHide(false);
    AppMethodBeat.o(130715);
  }
  
  public final void aqu()
  {
    int k = 0;
    AppMethodBeat.i(130716);
    View localView = this.eos.aqx();
    int i;
    if ((this.eou.getInputType() & 0x20000) > 0)
    {
      i = 1;
      j = k;
      if (i == 0) {
        if ((this.uHP == null) || (this.uHP.getVisibility() != 0)) {
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
  
  public final void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(220183);
    super.cK(paramBoolean);
    if (!paramBoolean) {
      c.ch(this.uHU.getHostActivity()).jCH();
    }
    AppMethodBeat.o(220183);
  }
  
  public final void cL(boolean paramBoolean)
  {
    AppMethodBeat.i(220186);
    if ((cRB()) && (this.uHN != null)) {
      this.uHN.cL(paramBoolean);
    }
    AppMethodBeat.o(220186);
  }
  
  public final WAGamePanelInputEditText getAttachedEditText()
  {
    AppMethodBeat.i(130717);
    WAGamePanelInputEditText localWAGamePanelInputEditText = (WAGamePanelInputEditText)super.getAttachedEditText();
    AppMethodBeat.o(130717);
    return localWAGamePanelInputEditText;
  }
  
  public final void mo(int paramInt)
  {
    AppMethodBeat.i(220182);
    int i = paramInt;
    if (paramInt > 0)
    {
      i = paramInt;
      if (2 == ((u)n.ed(this).getOnLayoutListener()).uGY)
      {
        Object localObject = this.uHU.getHostActivity();
        i = paramInt;
        if (ae.fm((Context)localObject))
        {
          i = paramInt;
          if (Build.VERSION.SDK_INT <= 29)
          {
            localObject = ay.bY((Activity)localObject);
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
    super.mo(i);
    AppMethodBeat.o(220182);
  }
  
  public final void setOnConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.eov = paramOnClickListener;
  }
  
  public final void setOnEmoticonOperationListener(e parame)
  {
    AppMethodBeat.i(220191);
    if (this.uHN != null) {
      this.uHN.setOnEmoticonOperationListener(parame);
    }
    AppMethodBeat.o(220191);
  }
  
  public final void show()
  {
    AppMethodBeat.i(130718);
    if (this.uHU.getHostActivity() != null) {}
    try
    {
      localu = (u)n.ed(this).getOnLayoutListener();
      Activity localActivity = this.uHU.getHostActivity();
      if ((Build.VERSION.SDK_INT < 24) || (localActivity == null) || (!localActivity.isInMultiWindowMode())) {
        break label149;
      }
      i = 1;
      if (i == 0)
      {
        localActivity = this.uHU.getHostActivity();
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
    this.uHU.getHostActivity().getWindow().setSoftInputMode(16);
    localu.Ep(1);
    for (;;)
    {
      this.uHT = this.eou;
      this.eou.requestFocus();
      super.show();
      AppMethodBeat.o(130718);
      return;
      i = 0;
      break;
      i = 0;
      break label205;
      this.uHU.getHostActivity().getWindow().setSoftInputMode(48);
      localu.Ep(2);
    }
  }
  
  public static final class a
    extends FrameLayout
    implements aa.a
  {
    public View eoy;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(130708);
      if (a.aqw() != null) {
        a.aqw().g(this);
      }
      for (;;)
      {
        ((Button)findViewById(a.d.game_edit_send)).setText(a.f.appbrand_game_input_confirm);
        setClickable(true);
        AppMethodBeat.o(130708);
        return;
        LayoutInflater.from(paramContext).inflate(a.e.app_brand_game_input_panel_edit_bar, this, true);
      }
    }
    
    public final View aqx()
    {
      AppMethodBeat.i(130707);
      if (this.eoy == null) {
        this.eoy = findViewById(a.d.game_edit_send);
      }
      View localView = this.eoy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */