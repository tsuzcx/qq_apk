package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class CardViewEntranceUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2131493339;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113591);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
      setResult(0, paramBundle);
      finish();
      AppMethodBeat.o(113591);
      return;
    }
    int i = paramBundle.getIntExtra("key_from_scene", 50);
    Log.i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
    Object localObject = paramBundle.getStringExtra("card_list");
    String str = paramBundle.getStringExtra("key_app_id");
    Log.d("MicroMsg.CardViewEntranceUI", "appid: %s", new Object[] { str });
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
      setResult(0, paramBundle);
      finish();
      AppMethodBeat.o(113591);
      return;
    }
    LinkedList localLinkedList = k.G((String)localObject, i, str);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
      setResult(0, paramBundle);
      finish();
      AppMethodBeat.o(113591);
      return;
    }
    Intent localIntent = new Intent();
    if (localLinkedList.size() == 1)
    {
      localIntent.putExtra("card_list", (String)localObject);
      localIntent.putExtra("key_app_id", str);
      localIntent.putExtra("key_from_scene", 50);
      localIntent.putExtra("key_previous_scene", i);
      if (!Util.isNullOrNil(paramBundle.getStringExtra("key_template_id"))) {
        localIntent.putExtra("key_template_id", paramBundle.getStringExtra("key_template_id"));
      }
      localIntent.putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      localIntent.setClass(this, CardDetailUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
      setResult(-1, paramBundle);
      finish();
      AppMethodBeat.o(113591);
      return;
      localIntent.putExtra("view_type", 0);
      localIntent.putExtra("card_list", (String)localObject);
      localIntent.putExtra("key_previous_scene", i);
      if (!Util.isNullOrNil(paramBundle.getStringExtra("key_template_id"))) {
        localIntent.putExtra("key_template_id", paramBundle.getStringExtra("key_template_id"));
      }
      localIntent.putExtra("key_app_id", str);
      localIntent.putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      localIntent.setClass(this, CardViewUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewEntranceUI
 * JD-Core Version:    0.7.0.1
 */