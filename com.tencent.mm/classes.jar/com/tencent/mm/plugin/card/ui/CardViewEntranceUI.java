package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class CardViewEntranceUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2130968910;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88664);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
      setResult(0, paramBundle);
      finish();
      AppMethodBeat.o(88664);
      return;
    }
    int i = paramBundle.getIntExtra("key_from_scene", 50);
    ab.i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
    String str1 = paramBundle.getStringExtra("card_list");
    String str2 = paramBundle.getStringExtra("key_app_id");
    ab.d("MicroMsg.CardViewEntranceUI", "appid: %s", new Object[] { str2 });
    if (TextUtils.isEmpty(str1))
    {
      ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
      setResult(0, paramBundle);
      finish();
      AppMethodBeat.o(88664);
      return;
    }
    LinkedList localLinkedList = k.r(str1, i, str2);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
      setResult(0, paramBundle);
      finish();
      AppMethodBeat.o(88664);
      return;
    }
    Intent localIntent = new Intent();
    if (localLinkedList.size() == 1)
    {
      localIntent.putExtra("card_list", str1);
      localIntent.putExtra("key_from_scene", 50);
      localIntent.putExtra("key_previous_scene", i);
      if (!bo.isNullOrNil(paramBundle.getStringExtra("key_template_id"))) {
        localIntent.putExtra("key_template_id", paramBundle.getStringExtra("key_template_id"));
      }
      localIntent.putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      localIntent.setClass(this, CardDetailUI.class);
      startActivity(localIntent);
    }
    for (;;)
    {
      ab.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
      setResult(-1, paramBundle);
      finish();
      AppMethodBeat.o(88664);
      return;
      localIntent.putExtra("view_type", 0);
      localIntent.putExtra("card_list", str1);
      localIntent.putExtra("key_previous_scene", i);
      if (!bo.isNullOrNil(paramBundle.getStringExtra("key_template_id"))) {
        localIntent.putExtra("key_template_id", paramBundle.getStringExtra("key_template_id"));
      }
      localIntent.putExtra("key_app_id", str2);
      localIntent.putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      localIntent.setClass(this, CardViewUI.class);
      startActivity(localIntent);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewEntranceUI
 * JD-Core Version:    0.7.0.1
 */