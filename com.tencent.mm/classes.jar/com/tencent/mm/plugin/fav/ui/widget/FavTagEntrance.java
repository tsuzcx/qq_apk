package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class FavTagEntrance
  extends LinearLayout
  implements j.a
{
  private long bTZ = -1L;
  private TextView kjH;
  private String kjI = String.valueOf(this.bTZ);
  
  public FavTagEntrance(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(String paramString, l paraml)
  {
    y.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[] { paramString, this.kjI });
    if (this.kjI.equals(paramString))
    {
      paramString = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.bTZ);
      if (paramString == null) {
        y.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[] { Long.valueOf(this.bTZ) });
      }
    }
    else
    {
      return;
    }
    setTagContent(paramString.field_tagProto.sXq);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kjH = ((TextView)findViewById(n.e.tag_content));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_scene", 1);
        paramAnonymousView.putExtra("key_fav_item_id", FavTagEntrance.a(FavTagEntrance.this));
        b.a(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", paramAnonymousView);
      }
    });
  }
  
  public void setFavItemID(long paramLong)
  {
    this.bTZ = paramLong;
    this.kjI = String.valueOf(paramLong);
  }
  
  public void setTagContent(List<String> paramList)
  {
    if (this.kjH == null) {
      return;
    }
    Object localObject = getContext();
    if ((localObject == null) || (paramList == null) || (paramList.isEmpty()))
    {
      localObject = "";
      if (bk.bl((String)localObject))
      {
        this.kjH.setText("");
        this.kjH.setHint(n.i.favorite_entrance_add_tag_tips);
      }
    }
    else
    {
      String str1 = (String)paramList.get(0);
      String str2 = ((Context)localObject).getResources().getString(n.i.favorite_tag_delimiter);
      int i = 1;
      for (;;)
      {
        localObject = str1;
        if (i >= paramList.size()) {
          break;
        }
        str1 = str1 + str2 + (String)paramList.get(i);
        i += 1;
      }
    }
    this.kjH.setText(j.a(getContext(), (CharSequence)localObject, this.kjH.getTextSize()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance
 * JD-Core Version:    0.7.0.1
 */