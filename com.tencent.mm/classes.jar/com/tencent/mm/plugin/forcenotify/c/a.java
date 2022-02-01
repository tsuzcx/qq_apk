package com.tencent.mm.plugin.forcenotify.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.plugin.forcenotify.a.g;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.ui.b;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.j;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "showTimeMs", "", "(Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "removeSelfTask", "Ljava/lang/Runnable;", "getShowTimeMs", "()J", "setShowTimeMs", "(J)V", "getIconColor", "", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "getWindowTitle", "isExposing", "", "needSound", "needVibrate", "onAddToList", "", "onExpose", "onFullScreenClick", "view", "Landroid/view/View;", "onHide", "onItemClick", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onRemoveFromList", "onUpdateInList", "setExposing", "token", "Companion", "MsgState", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements com.tencent.mm.view.recyclerview.a
{
  public static final a.a Hoh = new a.a((byte)0);
  private static final HashMap<String, a.b> Hok = new HashMap();
  public long Hoi;
  public final Runnable Hoj;
  public final String id;
  
  public a(String paramString, long paramLong)
  {
    this.id = paramString;
    this.Hoi = paramLong;
    this.Hoj = new a..ExternalSyntheticLambda0(this);
    paramString = (a.b)Hok.get(this.id);
    boolean bool;
    if (paramString == null)
    {
      bool = false;
      paramString = (a.b)Hok.get(this.id);
      if (paramString != null) {
        break label121;
      }
    }
    label121:
    for (paramString = s.X(this.id, "-removeSelf");; paramString = paramString.token)
    {
      ((Map)Hok).put(this.id, new a.b(this.id, paramString, bool));
      return;
      bool = paramString.Hol;
      break;
    }
  }
  
  private static final void a(a parama)
  {
    s.u(parama, "this$0");
    Log.i("MicroMsg.ForceNotifyMsgItem", "id=" + parama.id + " timeout, removeSelf!");
    b.a locala = b.HoY;
    b.a.fwZ().aDU(parama.id);
  }
  
  public abstract void a(j paramj, View paramView);
  
  public abstract boolean dWY();
  
  public abstract boolean dWZ();
  
  public String dXa()
  {
    String str = MMApplicationContext.getContext().getString(a.h.force_notify);
    s.s(str, "getContext().getString(R.string.force_notify)");
    return str;
  }
  
  public Drawable dXb()
  {
    return com.tencent.mm.svg.a.a.i(MMApplicationContext.getResources(), a.g.wechat_icon);
  }
  
  public void fwE()
  {
    Log.i("MicroMsg.ForceNotifyMsgItem", "id=" + this.id + " onAddToList");
  }
  
  public final void fwF()
  {
    Log.i("MicroMsg.ForceNotifyMsgItem", "id=" + this.id + " onUpdateInList");
    String str = fwI();
    b.a locala = b.HoY;
    b.a.fwZ().fJ(str);
    if (fwH())
    {
      locala = b.HoY;
      b.a.fwZ().a(this.Hoj, this.Hoi, str);
    }
  }
  
  public void fwG()
  {
    Log.i("MicroMsg.ForceNotifyMsgItem", "id=" + this.id + " onRemoveFromList");
    vM(false);
    b.a locala = b.HoY;
    b.a.fwZ().fJ(fwI());
  }
  
  public final boolean fwH()
  {
    a.b localb = (a.b)Hok.get(this.id);
    if (localb == null) {
      return false;
    }
    return localb.Hol;
  }
  
  public final String fwI()
  {
    a.b localb = (a.b)Hok.get(this.id);
    if (localb == null) {
      return "";
    }
    return localb.token;
  }
  
  public int getIconColor()
  {
    b.a locala = b.HoY;
    if (b.a.fwZ().isDarkMode()) {
      return MMApplicationContext.getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_text_white_50);
    }
    return MMApplicationContext.getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_text_dark_50);
  }
  
  public abstract void hp(View paramView);
  
  public final void vM(boolean paramBoolean)
  {
    a.b localb = (a.b)Hok.get(this.id);
    if (localb != null) {
      localb.Hol = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */