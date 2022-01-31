package com.tencent.mm.plugin.emojicapture.ui;

import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureBeautySettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "chinInputText", "Landroid/widget/EditText;", "eyeInputText", "faceVInputText", "noseInputText", "shapeInputText", "skinInputText", "clamp", "", "value", "min", "max", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "saveParam", "plugin-emojicapture_release"})
public final class EmojiCaptureBeautySettingUI
  extends MMActivity
{
  private EditText lwQ;
  private EditText lwR;
  private EditText lwS;
  private EditText lwT;
  private EditText lwU;
  private EditText lwV;
  
  private static int ef(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2859);
    paramInt1 = Math.min(100, Math.max(paramInt2, paramInt1));
    AppMethodBeat.o(2859);
    return paramInt1;
  }
  
  public final int getLayoutId()
  {
    return 2130969355;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(2857);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new EmojiCaptureBeautySettingUI.a(this));
    paramBundle = findViewById(2131823526);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(2857);
      throw paramBundle;
    }
    this.lwQ = ((EditText)paramBundle);
    paramBundle = findViewById(2131823527);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(2857);
      throw paramBundle;
    }
    this.lwR = ((EditText)paramBundle);
    paramBundle = findViewById(2131823528);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(2857);
      throw paramBundle;
    }
    this.lwS = ((EditText)paramBundle);
    paramBundle = findViewById(2131823529);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(2857);
      throw paramBundle;
    }
    this.lwT = ((EditText)paramBundle);
    paramBundle = findViewById(2131823530);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(2857);
      throw paramBundle;
    }
    this.lwU = ((EditText)paramBundle);
    paramBundle = findViewById(2131823531);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.EditText");
      AppMethodBeat.o(2857);
      throw paramBundle;
    }
    this.lwV = ((EditText)paramBundle);
    paramBundle = ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
    int i = paramBundle.getInt("skin", 50);
    int j = paramBundle.getInt("shape", 20);
    int k = paramBundle.getInt("faceV", 0);
    int m = paramBundle.getInt("eye", 0);
    int n = paramBundle.getInt("nose", 0);
    int i1 = paramBundle.getInt("chin", 0);
    paramBundle = this.lwQ;
    if (paramBundle == null) {
      a.f.b.j.ays("skinInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(i));
    paramBundle = this.lwR;
    if (paramBundle == null) {
      a.f.b.j.ays("shapeInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(j));
    paramBundle = this.lwS;
    if (paramBundle == null) {
      a.f.b.j.ays("faceVInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(k));
    paramBundle = this.lwT;
    if (paramBundle == null) {
      a.f.b.j.ays("eyeInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(m));
    paramBundle = this.lwU;
    if (paramBundle == null) {
      a.f.b.j.ays("noseInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(n));
    paramBundle = this.lwV;
    if (paramBundle == null) {
      a.f.b.j.ays("chinInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(i1));
    AppMethodBeat.o(2857);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(2858);
    super.onDestroy();
    Object localObject = this.lwQ;
    if (localObject == null) {
      a.f.b.j.ays("skinInputText");
    }
    int i = com.tencent.mm.c.j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.lwR;
    if (localObject == null) {
      a.f.b.j.ays("shapeInputText");
    }
    int j = com.tencent.mm.c.j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.lwS;
    if (localObject == null) {
      a.f.b.j.ays("faceVInputText");
    }
    int k = com.tencent.mm.c.j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.lwT;
    if (localObject == null) {
      a.f.b.j.ays("eyeInputText");
    }
    int m = com.tencent.mm.c.j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.lwU;
    if (localObject == null) {
      a.f.b.j.ays("noseInputText");
    }
    int n = com.tencent.mm.c.j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.lwV;
    if (localObject == null) {
      a.f.b.j.ays("chinInputText");
    }
    int i1 = com.tencent.mm.c.j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = ah.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("skin", ef(i, 0));
    ((SharedPreferences.Editor)localObject).putInt("shape", ef(j, 0));
    ((SharedPreferences.Editor)localObject).putInt("faceV", ef(k, 0));
    ((SharedPreferences.Editor)localObject).putInt("eye", ef(m, 0));
    ((SharedPreferences.Editor)localObject).putInt("nose", ef(n, 0));
    ((SharedPreferences.Editor)localObject).putInt("chin", ef(i1, -100));
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(2858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI
 * JD-Core Version:    0.7.0.1
 */