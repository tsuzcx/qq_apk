package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.luggage.wxa.b.a.c;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tenpay.miniapp.MiniAppKeyboardWindow;

class AppBrandSecureKeyboard
  extends MiniAppKeyboardWindow
{
  public AppBrandSecureKeyboard(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandSecureKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void bAy()
  {
    AppMethodBeat.i(214177);
    Button localButton = (Button)findViewById(getId("tenpay_keyboard_0"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_1"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_2"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_3"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_4"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_5"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_6"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_7"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_8"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_9"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_new_force_light);
    localButton = (Button)findViewById(getId("tenpay_keyboard_x"));
    localButton.setTextColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    localButton.setBackgroundResource(a.d.tenpay_keybtn_bottom_new_force_light);
    findViewById(getId("tenpay_keyboard_d")).setBackgroundResource(a.d.tenpay_keybtn_bottom_new_force_light);
    ((WeImageView)findViewById(getId("tenpay_keyboard_d_inner"))).setIconColor(getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    findViewById(a.e.root_view).setBackgroundResource(a.c.BW_BG_100);
    findViewById(a.e.divider1).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider2).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider3).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider4).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider5).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider6).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider7).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider8).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider9).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider10).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider11).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    findViewById(a.e.divider12).setBackgroundResource(a.c.UN_BW_0_Alpha_0_1);
    AppMethodBeat.o(214177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandSecureKeyboard
 * JD-Core Version:    0.7.0.1
 */