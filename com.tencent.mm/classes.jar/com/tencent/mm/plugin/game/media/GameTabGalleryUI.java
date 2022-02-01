package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import org.json.JSONArray;
import org.json.JSONException;

public class GameTabGalleryUI
  extends MMActivity
{
  private static final int CFC;
  private m CFD;
  
  static
  {
    AppMethodBeat.i(41075);
    CFC = "GameTabGalleryUI".hashCode() & 0xFFFF;
    AppMethodBeat.o(41075);
  }
  
  private void init()
  {
    AppMethodBeat.i(203566);
    this.CFD = new m(getContext(), CFC);
    boolean bool = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
    int i = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    this.CFD.U(bool, i);
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
          localObject2 = com.tencent.mm.plugin.game.commlib.a.ewl();
        }
        this.CFD.setLocalAlbumInfos((JSONArray)localObject2);
        setContentView(this.CFD);
        setMMTitle(g.i.Cjj);
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
        AppMethodBeat.o(203566);
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
    if ((paramInt1 == CFC) && (paramInt2 == -1))
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
    paramBundle = getString(b.i.permission_tips_title);
    String str = getString(g.i.CoQ);
    if (b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, paramBundle, str)) {
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
    AppMethodBeat.i(203568);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.GameTabGalleryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(203568);
      return;
    }
    Log.i("MicroMsg.GameTabGalleryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203568);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        init();
        AppMethodBeat.o(203568);
        return;
      }
      h.a(this, getString(g.i.CpA), getString(g.i.permission_tips_title), getString(g.i.jump_to_settings), getString(g.i.gallery_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(197154);
          paramAnonymousDialogInterface = GameTabGalleryUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/media/GameTabGalleryUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/game/media/GameTabGalleryUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          GameTabGalleryUI.this.finish();
          AppMethodBeat.o(197154);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194033);
          GameTabGalleryUI.this.finish();
          AppMethodBeat.o(194033);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameTabGalleryUI
 * JD-Core Version:    0.7.0.1
 */