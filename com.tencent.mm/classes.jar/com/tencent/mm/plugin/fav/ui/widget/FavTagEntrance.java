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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public class FavTagEntrance
  extends LinearLayout
  implements k.a
{
  private long dBy;
  private TextView rEQ;
  private String rER;
  
  public FavTagEntrance(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107546);
    this.dBy = -1L;
    this.rER = String.valueOf(this.dBy);
    AppMethodBeat.o(107546);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(107550);
    ad.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[] { paramString, this.rER });
    if (this.rER.equals(paramString))
    {
      paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.dBy);
      if (paramString == null)
      {
        ad.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[] { Long.valueOf(this.dBy) });
        AppMethodBeat.o(107550);
        return;
      }
      setTagContent(paramString.field_tagProto.GjJ);
    }
    AppMethodBeat.o(107550);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107547);
    super.onFinishInflate();
    this.rEQ = ((TextView)findViewById(2131305622));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107545);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavTagEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_scene", 1);
        paramAnonymousView.putExtra("key_fav_item_id", FavTagEntrance.a(FavTagEntrance.this));
        com.tencent.mm.plugin.fav.a.b.b(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavTagEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107545);
      }
    });
    AppMethodBeat.o(107547);
  }
  
  public void setFavItemID(long paramLong)
  {
    AppMethodBeat.i(107548);
    this.dBy = paramLong;
    this.rER = String.valueOf(paramLong);
    AppMethodBeat.o(107548);
  }
  
  public void setTagContent(List<String> paramList)
  {
    AppMethodBeat.i(107549);
    if (this.rEQ == null)
    {
      AppMethodBeat.o(107549);
      return;
    }
    Object localObject = getContext();
    if ((localObject == null) || (paramList == null) || (paramList.isEmpty()))
    {
      localObject = "";
      if (bt.isNullOrNil((String)localObject))
      {
        this.rEQ.setText("");
        this.rEQ.setHint(2131758880);
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
    this.rEQ.setText(k.b(getContext(), (CharSequence)localObject, this.rEQ.getTextSize()));
    AppMethodBeat.o(107549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance
 * JD-Core Version:    0.7.0.1
 */