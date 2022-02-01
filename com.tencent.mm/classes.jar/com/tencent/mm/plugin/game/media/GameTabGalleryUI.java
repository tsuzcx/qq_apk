package com.tencent.mm.plugin.game.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import org.json.JSONArray;
import org.json.JSONException;

public class GameTabGalleryUI
  extends MMActivity
{
  private static final int IzG;
  private m IzH;
  
  static
  {
    AppMethodBeat.i(41075);
    IzG = "GameTabGalleryUI".hashCode() & 0xFFFF;
    AppMethodBeat.o(41075);
  }
  
  private void init()
  {
    AppMethodBeat.i(276857);
    this.IzH = new m(getContext(), IzG);
    boolean bool = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
    int i = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    this.IzH.W(bool, i);
    Object localObject2 = getIntent().getStringExtra("game_haowan_local_albums_info");
    Object localObject1 = new JSONArray();
    if (!Util.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (((JSONArray)localObject1).length() == 0) {
          localObject2 = a.fEa();
        }
        this.IzH.setLocalAlbumInfos((JSONArray)localObject2);
        setContentView(this.IzH);
        setMMTitle(h.i.HVr);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(41069);
            GameTabGalleryUI.this.finish();
            AppMethodBeat.o(41069);
            return false;
          }
        });
        AppMethodBeat.o(276857);
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41074);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == IzG) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    AppMethodBeat.o(41074);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41070);
    super.onCreate(paramBundle);
    getString(b.i.permission_tips_title);
    paramBundle = getString(h.i.IaY);
    if (b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, paramBundle)) {
      init();
    }
    AppMethodBeat.o(41070);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41073);
    super.onDestroy();
    AppMethodBeat.o(41073);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41072);
    super.onPause();
    f.d(false, true, true);
    AppMethodBeat.o(41072);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(276867);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.GameTabGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(276867);
      return;
    }
    Log.i("MicroMsg.GameTabGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(276867);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(276867);
        return;
      }
      k.a(this, getString(h.i.IbI), getString(h.i.permission_tips_title), getString(h.i.jump_to_settings), getString(h.i.gallery_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(276808);
          b.lx(GameTabGalleryUI.this.getContext());
          GameTabGalleryUI.this.finish();
          AppMethodBeat.o(276808);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(276809);
          GameTabGalleryUI.this.finish();
          AppMethodBeat.o(276809);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41071);
    super.onResume();
    f.d(true, true, true);
    AppMethodBeat.o(41071);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameTabGalleryUI
 * JD-Core Version:    0.7.0.1
 */