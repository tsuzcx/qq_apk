package com.tencent.mm.plugin.flutter.e.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class i
  implements com.tencent.mm.ak.i
{
  private static volatile i wKc = null;
  HashMap<c, q> wKd;
  private final MStorage.IOnStorageChange wKe;
  private final MStorage.IOnStorageChange wKf;
  private final IListener wKg;
  
  private i()
  {
    AppMethodBeat.i(240958);
    this.wKd = new HashMap();
    this.wKe = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(240954);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MMVideoEditorEmojiPaneiOperate", "modify emoji group .");
          i.dLY();
        }
        AppMethodBeat.o(240954);
      }
    };
    this.wKf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(240955);
        Log.i("MMVideoEditorEmojiPaneiOperate", "emoji storage notify %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(240955);
          return;
        }
        i.dLY();
        AppMethodBeat.o(240955);
      }
    };
    this.wKg = new IListener() {};
    if (MMApplicationContext.isMainProcess()) {
      g.aAg().hqi.a(698, this);
    }
    ((d)g.ah(d.class)).getProvider().k(this.wKe);
    ((d)g.ah(d.class)).getProvider().i(this.wKf);
    EventCenter.instance.addListener(this.wKg);
    AppMethodBeat.o(240958);
  }
  
  public static i dLX()
  {
    AppMethodBeat.i(240959);
    if (wKc == null) {}
    try
    {
      if (wKc == null) {
        wKc = new i();
      }
      i locali = wKc;
      AppMethodBeat.o(240959);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(240959);
    }
  }
  
  public final void br(int paramInt, String paramString)
  {
    AppMethodBeat.i(240960);
    if ((paramInt == 0) || (paramInt == 1))
    {
      c localc = new c(paramInt, 2, Collections.singletonList(paramString));
      paramString = new q(paramString, paramInt);
      this.wKd.put(localc, paramString);
      g.aAg().hqi.a(localc, 0);
    }
    AppMethodBeat.o(240960);
  }
  
  public final void bs(int paramInt, String paramString)
  {
    AppMethodBeat.i(240961);
    if ((paramInt == 0) || (paramInt == 1))
    {
      c localc = new c(paramInt, 3, Collections.singletonList(paramString));
      paramString = new q(paramString, paramInt);
      this.wKd.put(localc, paramString);
      g.aAg().hqi.a(localc, 0);
    }
    AppMethodBeat.o(240961);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(240962);
    if (!this.wKd.containsKey(paramq))
    {
      AppMethodBeat.o(240962);
      return;
    }
    Object localObject = (q)this.wKd.get(paramq);
    paramString = ((q)localObject).md5;
    int i = ((q)localObject).gYc;
    localObject = Collections.singletonList(paramString);
    Log.i("MMVideoEditorEmojiPaneiOperate", "onSceneEnd: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
    if (paramq != null) {
      if (((c)paramq).kfa == 3)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (i == 0)
          {
            j.auL().dW(true);
            j.auL().dV(true);
          }
          for (;;)
          {
            bj.gCJ().OpN.x(i, (List)localObject);
            AppMethodBeat.o(240962);
            return;
            j.auL().dY(true);
          }
        }
      }
      else if ((((c)paramq).kfa == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i != 0) {
          break label226;
        }
        j.auL().dW(true);
        j.auL().dV(true);
      }
    }
    for (;;)
    {
      bj.gCJ().OpN.I((List)localObject, i);
      AppMethodBeat.o(240962);
      return;
      label226:
      j.auL().dY(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */