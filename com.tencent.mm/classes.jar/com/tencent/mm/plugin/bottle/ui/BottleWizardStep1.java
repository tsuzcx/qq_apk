package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class BottleWizardStep1
  extends MMActivity
{
  private ImageView hZJ = null;
  
  private void awW()
  {
    Bitmap localBitmap = b.a(ad.aaZ(q.Gj()), false, -1);
    if (localBitmap == null) {
      localBitmap = b.a(q.Gj(), false, -1);
    }
    for (;;)
    {
      this.hZJ = ((ImageView)findViewById(R.h.image_headimg_wizard));
      if (localBitmap != null) {
        this.hZJ.setImageBitmap(localBitmap);
      }
      return;
    }
  }
  
  private void awX()
  {
    if (!l.c(this, e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(R.l.selectcameraapp_none), 1).show();
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.bottle_wizard_step1;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.bottle_beach_title);
    ((LinearLayout)findViewById(R.h.image_headimg_wizard_btn)).setOnClickListener(new BottleWizardStep1.1(this));
    setBackBtn(new BottleWizardStep1.2(this));
    addTextOptionMenu(0, getString(R.l.app_nextstep), new BottleWizardStep1.3(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = getApplicationContext();
            au.Hx();
            paramIntent = l.f((Context)localObject1, paramIntent, c.FG());
          } while (paramIntent == null);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("CropImageMode", 1);
          ((Intent)localObject1).putExtra("CropImage_OutputPath", paramIntent);
          ((Intent)localObject1).putExtra("CropImage_ImgPath", paramIntent);
          a.eUR.a(this, (Intent)localObject1, 4);
          return;
        } while (paramIntent == null);
        localObject1 = getApplicationContext();
        au.Hx();
        localObject2 = l.f((Context)localObject1, paramIntent, c.FG());
      } while (localObject2 == null);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 1);
      ((Intent)localObject1).putExtra("CropImage_ImgPath", (String)localObject2);
      Object localObject2 = new StringBuilder();
      o.JQ();
      ((Intent)localObject1).putExtra("CropImage_OutputPath", d.A(ad.aaZ(q.Gj()), true) + ".crop");
      a.eUR.a((Intent)localObject1, 4, this, paramIntent);
      return;
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    if (paramIntent == null)
    {
      y.e("MicroMsg.BottleWizardStep1", "crop picture failed");
      return;
    }
    new com.tencent.mm.ag.m(this.mController.uMN, paramIntent).b(2, new BottleWizardStep1.6(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.BottleWizardStep1", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      awX();
      return;
    }
    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new BottleWizardStep1.5(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    awW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleWizardStep1
 * JD-Core Version:    0.7.0.1
 */