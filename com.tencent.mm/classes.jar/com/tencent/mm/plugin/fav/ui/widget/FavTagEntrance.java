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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;

public class FavTagEntrance
  extends LinearLayout
  implements MStorage.IOnStorageChange
{
  private long dUt;
  private TextView tmM;
  private String tmN;
  
  public FavTagEntrance(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107546);
    this.dUt = -1L;
    this.tmN = String.valueOf(this.dUt);
    AppMethodBeat.o(107546);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107547);
    super.onFinishInflate();
    this.tmM = ((TextView)findViewById(2131308863));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107545);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavTagEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107550);
    Log.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[] { paramString, this.tmN });
    if (this.tmN.equals(paramString))
    {
      paramString = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.dUt);
      if (paramString == null)
      {
        Log.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[] { Long.valueOf(this.dUt) });
        AppMethodBeat.o(107550);
        return;
      }
      setTagContent(paramString.field_tagProto.Lyo);
    }
    AppMethodBeat.o(107550);
  }
  
  public void setFavItemID(long paramLong)
  {
    AppMethodBeat.i(107548);
    this.dUt = paramLong;
    this.tmN = String.valueOf(paramLong);
    AppMethodBeat.o(107548);
  }
  
  public void setTagContent(List<String> paramList)
  {
    AppMethodBeat.i(107549);
    if (this.tmM == null)
    {
      AppMethodBeat.o(107549);
      return;
    }
    Object localObject = getContext();
    if ((localObject == null) || (paramList == null) || (paramList.isEmpty()))
    {
      localObject = "";
      if (Util.isNullOrNil((String)localObject))
      {
        this.tmM.setText("");
        this.tmM.setHint(2131759204);
        AppMethodBeat.o(107549);
      }
    }
    else
    {
      String str1 = (String)paramList.get(0);
      String str2 = ((Context)localObject).getResources().getString(2131759345);
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
    this.tmM.setText(l.b(getContext(), (CharSequence)localObject, this.tmM.getTextSize()));
    AppMethodBeat.o(107549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance
 * JD-Core Version:    0.7.0.1
 */