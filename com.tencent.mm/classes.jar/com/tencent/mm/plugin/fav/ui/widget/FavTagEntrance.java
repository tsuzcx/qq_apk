package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public class FavTagEntrance
  extends LinearLayout
  implements k.a
{
  private long dpL;
  private TextView qUC;
  private String qUD;
  
  public FavTagEntrance(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107546);
    this.dpL = -1L;
    this.qUD = String.valueOf(this.dpL);
    AppMethodBeat.o(107546);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(107550);
    ac.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[] { paramString, this.qUD });
    if (this.qUD.equals(paramString))
    {
      paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(this.dpL);
      if (paramString == null)
      {
        ac.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[] { Long.valueOf(this.dpL) });
        AppMethodBeat.o(107550);
        return;
      }
      setTagContent(paramString.field_tagProto.EBX);
    }
    AppMethodBeat.o(107550);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107547);
    super.onFinishInflate();
    this.qUC = ((TextView)findViewById(2131305622));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107545);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_scene", 1);
        paramAnonymousView.putExtra("key_fav_item_id", FavTagEntrance.a(FavTagEntrance.this));
        b.b(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", paramAnonymousView);
        AppMethodBeat.o(107545);
      }
    });
    AppMethodBeat.o(107547);
  }
  
  public void setFavItemID(long paramLong)
  {
    AppMethodBeat.i(107548);
    this.dpL = paramLong;
    this.qUD = String.valueOf(paramLong);
    AppMethodBeat.o(107548);
  }
  
  public void setTagContent(List<String> paramList)
  {
    AppMethodBeat.i(107549);
    if (this.qUC == null)
    {
      AppMethodBeat.o(107549);
      return;
    }
    Object localObject = getContext();
    if ((localObject == null) || (paramList == null) || (paramList.isEmpty()))
    {
      localObject = "";
      if (bs.isNullOrNil((String)localObject))
      {
        this.qUC.setText("");
        this.qUC.setHint(2131758880);
        AppMethodBeat.o(107549);
      }
    }
    else
    {
      String str1 = (String)paramList.get(0);
      String str2 = ((Context)localObject).getResources().getString(2131759019);
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
    this.qUC.setText(k.b(getContext(), (CharSequence)localObject, this.qUC.getTextSize()));
    AppMethodBeat.o(107549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance
 * JD-Core Version:    0.7.0.1
 */