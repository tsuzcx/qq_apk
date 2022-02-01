package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONArray;
import org.json.JSONException;

public class GameTabGalleryUI
  extends MMActivity
{
  private static final int tYg;
  private m tYh;
  
  static
  {
    AppMethodBeat.i(41075);
    tYg = "GameTabGalleryUI".hashCode() & 0xFFFF;
    AppMethodBeat.o(41075);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41074);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == tYg) && (paramInt2 == -1))
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
    this.tYh = new m(getContext(), tYg);
    boolean bool = getIntent().getBooleanExtra("game_haowan_ignore_video_preview", true);
    this.tYh.setIgnoreVideoPreview(bool);
    Object localObject = getIntent().getStringExtra("game_haowan_local_albums_info");
    paramBundle = new JSONArray();
    if (!bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        paramBundle = (Bundle)localObject;
        this.tYh.setLocalAlbumInfos(paramBundle);
        setContentView(this.tYh);
        setMMTitle(2131759882);
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
        AppMethodBeat.o(41070);
        return;
      }
      catch (JSONException localJSONException) {}
    }
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
    f.e(false, true, true);
    AppMethodBeat.o(41072);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41071);
    super.onResume();
    f.e(true, true, true);
    AppMethodBeat.o(41071);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameTabGalleryUI
 * JD-Core Version:    0.7.0.1
 */