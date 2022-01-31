package com.tencent.mm.plugin.emojicapture.ui;

import a.d.b.g;
import a.k;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.c.j;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class EmojiCaptureBeautySettingUI
  extends MMActivity
{
  private EditText jnY;
  private EditText jnZ;
  private EditText joa;
  private EditText job;
  private EditText joc;
  private EditText jod;
  
  private static int cH(int paramInt1, int paramInt2)
  {
    return Math.min(100, Math.max(paramInt2, paramInt1));
  }
  
  protected final int getLayoutId()
  {
    return a.e.emoji_capture_beauty_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new EmojiCaptureBeautySettingUI.a(this));
    paramBundle = findViewById(a.d.beauty_skin_para);
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type android.widget.EditText");
    }
    this.jnY = ((EditText)paramBundle);
    paramBundle = findViewById(a.d.beauty_shape_para);
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type android.widget.EditText");
    }
    this.jnZ = ((EditText)paramBundle);
    paramBundle = findViewById(a.d.beauty_facev_para);
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type android.widget.EditText");
    }
    this.joa = ((EditText)paramBundle);
    paramBundle = findViewById(a.d.beauty_eye_para);
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type android.widget.EditText");
    }
    this.job = ((EditText)paramBundle);
    paramBundle = findViewById(a.d.beauty_nose_para);
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type android.widget.EditText");
    }
    this.joc = ((EditText)paramBundle);
    paramBundle = findViewById(a.d.beauty_chin_para);
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type android.widget.EditText");
    }
    this.jod = ((EditText)paramBundle);
    paramBundle = ae.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0);
    int i = paramBundle.getInt("skin", 20);
    int j = paramBundle.getInt("shape", 10);
    int k = paramBundle.getInt("faceV", 0);
    int m = paramBundle.getInt("eye", 0);
    int n = paramBundle.getInt("nose", 0);
    int i1 = paramBundle.getInt("chin", 0);
    paramBundle = this.jnY;
    if (paramBundle == null) {
      g.ahh("skinInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(i));
    paramBundle = this.jnZ;
    if (paramBundle == null) {
      g.ahh("shapeInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(j));
    paramBundle = this.joa;
    if (paramBundle == null) {
      g.ahh("faceVInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(k));
    paramBundle = this.job;
    if (paramBundle == null) {
      g.ahh("eyeInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(m));
    paramBundle = this.joc;
    if (paramBundle == null) {
      g.ahh("noseInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(n));
    paramBundle = this.jod;
    if (paramBundle == null) {
      g.ahh("chinInputText");
    }
    paramBundle.setText((CharSequence)String.valueOf(i1));
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jnY;
    if (localObject == null) {
      g.ahh("skinInputText");
    }
    int i = j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.jnZ;
    if (localObject == null) {
      g.ahh("shapeInputText");
    }
    int j = j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.joa;
    if (localObject == null) {
      g.ahh("faceVInputText");
    }
    int k = j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.job;
    if (localObject == null) {
      g.ahh("eyeInputText");
    }
    int m = j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.joc;
    if (localObject == null) {
      g.ahh("noseInputText");
    }
    int n = j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = this.jod;
    if (localObject == null) {
      g.ahh("chinInputText");
    }
    int i1 = j.getInt(((EditText)localObject).getText().toString(), -1);
    localObject = ae.getContext().getSharedPreferences("EmojiCaptureDebugBeautyPara", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("skin", cH(i, 0));
    ((SharedPreferences.Editor)localObject).putInt("shape", cH(j, 0));
    ((SharedPreferences.Editor)localObject).putInt("faceV", cH(k, 0));
    ((SharedPreferences.Editor)localObject).putInt("eye", cH(m, 0));
    ((SharedPreferences.Editor)localObject).putInt("nose", cH(n, 0));
    ((SharedPreferences.Editor)localObject).putInt("chin", cH(i1, -100));
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI
 * JD-Core Version:    0.7.0.1
 */