package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BottlePersonalInfoUI
  extends MMPreference
  implements d.a
{
  private SharedPreferences dnD;
  private com.tencent.mm.ui.base.preference.f dnn;
  private HashMap<Integer, Integer> fcv = new HashMap();
  private c hZG;
  private int status;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 2;
    paramf = paramPreference.mKey;
    if (paramf.equals("bottle_settings_change_avatar"))
    {
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.gM(this);
        return false;
      }
      com.tencent.mm.pluginsdk.ui.tools.l.a(this, 2, null);
      return true;
    }
    if (paramf.equals("settings_district")) {
      return this.hZG.awV();
    }
    if (paramf.equals("settings_signature")) {
      return this.hZG.awU();
    }
    if (paramf.equals("bottle_settings_show_at_main"))
    {
      boolean bool = this.dnD.getBoolean("bottle_settings_show_at_main", true);
      y.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch change : open = " + bool + " item value = 32768 functionId = 14");
      if (bool) {}
      for (this.status |= 0x8000;; this.status &= 0xFFFF7FFF)
      {
        if (bool) {
          i = 1;
        }
        this.fcv.put(Integer.valueOf(14), Integer.valueOf(i));
        return true;
      }
    }
    if (paramf.equals("bottle_settings_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.mController.uMN, this.mController.uMN.getString(R.l.contact_info_clear_data), "", this.mController.uMN.getString(R.l.app_clear), this.mController.uMN.getString(R.l.app_cancel), new BottlePersonalInfoUI.2(this), null);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    boolean bool = true;
    setMMTitle(R.l.settings_title);
    this.dnn = this.vdd;
    this.dnn.addPreferencesFromResource(R.o.bottle_wizard_step2);
    this.dnD = this.dnD;
    this.status = q.Gn();
    Object localObject;
    if (getIntent().getBooleanExtra("is_allow_set", true))
    {
      this.hZG = new c(this, this.dnn);
      localObject = (CheckBoxPreference)this.dnn.add("bottle_settings_show_at_main");
      if ((this.status & 0x8000) == 0) {
        break label160;
      }
    }
    for (;;)
    {
      ((CheckBoxPreference)localObject).rHo = bool;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          BottlePersonalInfoUI.this.finish();
          return true;
        }
      });
      return;
      localObject = this.dnn;
      ((com.tencent.mm.ui.base.preference.f)localObject).ade("settings_sex");
      ((com.tencent.mm.ui.base.preference.f)localObject).ade("settings_district");
      ((com.tencent.mm.ui.base.preference.f)localObject).ade("settings_signature");
      ((com.tencent.mm.ui.base.preference.f)localObject).ade("bottle_settings_change_avatar_alert");
      break;
      label160:
      bool = false;
    }
  }
  
  public final void kk(String paramString)
  {
    if ((paramString != null) && (paramString.equals(ad.aaZ(q.Gj()))))
    {
      Bitmap localBitmap = b.a(paramString, false, -1);
      paramString = localBitmap;
      if (localBitmap == null) {
        paramString = b.a(q.Gj(), false, -1);
      }
      if (paramString != null) {
        break label73;
      }
      paramString = BitmapFactory.decodeResource(getResources(), R.g.default_avatar);
    }
    label73:
    for (;;)
    {
      ((HeadImgPreference)this.dnn.add("bottle_settings_change_avatar")).R(paramString);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = getApplicationContext();
            au.Hx();
            paramIntent = com.tencent.mm.pluginsdk.ui.tools.l.f((Context)localObject, paramIntent, com.tencent.mm.model.c.FG());
          } while (paramIntent == null);
          localObject = new Intent();
          ((Intent)localObject).putExtra("CropImageMode", 1);
          ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
          ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
          a.eUR.a(this, (Intent)localObject, 4);
          return;
        } while (paramIntent == null);
        localObject = getApplicationContext();
        au.Hx();
        localObject = com.tencent.mm.pluginsdk.ui.tools.l.f((Context)localObject, paramIntent, com.tencent.mm.model.c.FG());
      } while (localObject == null);
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      o.JQ();
      localIntent.putExtra("CropImage_OutputPath", d.A(ad.aaZ(q.Gj()), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      a.eUR.a(localIntent, 4, this, paramIntent);
      return;
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    if (paramIntent == null)
    {
      y.e("MicroMsg.BottleSettignsPersonalInfoUI", "crop picture failed");
      return;
    }
    new com.tencent.mm.ag.m(this.mController.uMN, paramIntent).b(2, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o.JQ().d(this);
    initView();
  }
  
  public void onDestroy()
  {
    a.eUS.tk();
    o.JQ().e(this);
    super.onDestroy();
  }
  
  public void onPause()
  {
    c.awT();
    au.Hx();
    com.tencent.mm.model.c.Dz().o(7, Integer.valueOf(this.status));
    Iterator localIterator = this.fcv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i = ((Integer)localEntry.getKey()).intValue();
      int j = ((Integer)localEntry.getValue()).intValue();
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.f(i, j));
      y.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch  " + i + " " + j);
    }
    this.fcv.clear();
    super.onPause();
  }
  
  public void onResume()
  {
    HeadImgPreference localHeadImgPreference = (HeadImgPreference)this.dnn.add("bottle_settings_change_avatar");
    Bitmap localBitmap2 = b.a(ad.aaZ(q.Gj()), false, -1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = b.a(q.Gj(), false, -1);
    }
    if (localBitmap1 != null) {
      localHeadImgPreference.R(localBitmap1);
    }
    localHeadImgPreference.nXW = new BottlePersonalInfoUI.3(this);
    if (this.hZG != null) {
      this.hZG.update();
    }
    super.onResume();
  }
  
  public final int xj()
  {
    return R.o.bottle_settings_pref_personal_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottlePersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */