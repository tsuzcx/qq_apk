package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class CardViewEntranceUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return a.e.card_add_entrance_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      y.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
      setResult(0, paramBundle);
      finish();
      return;
    }
    int i = paramBundle.getIntExtra("key_from_scene", 50);
    y.i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
    String str = paramBundle.getStringExtra("card_list");
    Object localObject = paramBundle.getStringExtra("key_app_id");
    y.d("MicroMsg.CardViewEntranceUI", "appid: %s", new Object[] { localObject });
    if (TextUtils.isEmpty(str))
    {
      y.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
      setResult(0, paramBundle);
      finish();
      return;
    }
    LinkedList localLinkedList = k.bp(str, i);
    if ((localLinkedList == null) || (localLinkedList.size() == 0))
    {
      y.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
      setResult(0, paramBundle);
      finish();
      return;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((mh)localIterator.next()).bOL = ((String)localObject);
    }
    localObject = new Intent();
    if (localLinkedList.size() == 1)
    {
      ((Intent)localObject).putExtra("card_list", str);
      ((Intent)localObject).putExtra("key_from_scene", 50);
      ((Intent)localObject).putExtra("key_previous_scene", i);
      if (!bk.bl(paramBundle.getStringExtra("key_template_id"))) {
        ((Intent)localObject).putExtra("key_template_id", paramBundle.getStringExtra("key_template_id"));
      }
      ((Intent)localObject).putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      ((Intent)localObject).setClass(this, CardDetailUI.class);
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      y.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
      setResult(-1, paramBundle);
      finish();
      return;
      ((Intent)localObject).putExtra("view_type", 0);
      ((Intent)localObject).putExtra("card_list", str);
      ((Intent)localObject).putExtra("key_previous_scene", i);
      if (!bk.bl(paramBundle.getStringExtra("key_template_id"))) {
        ((Intent)localObject).putExtra("key_template_id", paramBundle.getStringExtra("key_template_id"));
      }
      ((Intent)localObject).putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      ((Intent)localObject).setClass(this, CardViewUI.class);
      startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewEntranceUI
 * JD-Core Version:    0.7.0.1
 */