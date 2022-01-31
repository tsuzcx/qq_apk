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
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class FavTagEntrance
  extends LinearLayout
  implements k.a
{
  private long cBE;
  private TextView mEm;
  private String mEn;
  
  public FavTagEntrance(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74700);
    this.cBE = -1L;
    this.mEn = String.valueOf(this.cBE);
    AppMethodBeat.o(74700);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(74704);
    ab.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[] { paramString, this.mEn });
    if (this.mEn.equals(paramString))
    {
      paramString = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.cBE);
      if (paramString == null)
      {
        ab.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[] { Long.valueOf(this.cBE) });
        AppMethodBeat.o(74704);
        return;
      }
      setTagContent(paramString.field_tagProto.wVq);
    }
    AppMethodBeat.o(74704);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(74701);
    super.onFinishInflate();
    this.mEm = ((TextView)findViewById(2131824119));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74699);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_fav_scene", 1);
        paramAnonymousView.putExtra("key_fav_item_id", FavTagEntrance.a(FavTagEntrance.this));
        b.b(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", paramAnonymousView);
        AppMethodBeat.o(74699);
      }
    });
    AppMethodBeat.o(74701);
  }
  
  public void setFavItemID(long paramLong)
  {
    AppMethodBeat.i(74702);
    this.cBE = paramLong;
    this.mEn = String.valueOf(paramLong);
    AppMethodBeat.o(74702);
  }
  
  public void setTagContent(List<String> paramList)
  {
    AppMethodBeat.i(74703);
    if (this.mEm == null)
    {
      AppMethodBeat.o(74703);
      return;
    }
    Object localObject = getContext();
    if ((localObject == null) || (paramList == null) || (paramList.isEmpty()))
    {
      localObject = "";
      if (bo.isNullOrNil((String)localObject))
      {
        this.mEm.setText("");
        this.mEm.setHint(2131299708);
        AppMethodBeat.o(74703);
      }
    }
    else
    {
      String str1 = (String)paramList.get(0);
      String str2 = ((Context)localObject).getResources().getString(2131299843);
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
    this.mEm.setText(j.b(getContext(), (CharSequence)localObject, this.mEm.getTextSize()));
    AppMethodBeat.o(74703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance
 * JD-Core Version:    0.7.0.1
 */