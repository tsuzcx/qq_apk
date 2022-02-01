package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements e
{
  private Map<String, LinkedList<e.b>> zqE;
  private Map<String, LinkedList<e.a>> zqF;
  private Map<String, HashSet<e.c>> zqG;
  private com.tencent.mm.av.a.d.a<Long, CharSequence> zqH;
  private com.tencent.mm.av.a.d.a<Long, CharSequence> zqI;
  public q zqJ;
  
  public a()
  {
    AppMethodBeat.i(90754);
    this.zqE = new HashMap();
    this.zqF = new HashMap();
    this.zqG = new HashMap();
    this.zqH = new com.tencent.mm.av.a.d.a(200);
    this.zqI = new com.tencent.mm.av.a.d.a(500);
    this.zqJ = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(90750);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[] { paramAnonymousMap.toString() });
        a.a(a.this, paramAnonymousString, paramAnonymousMap, paramAnonymousa);
        AppMethodBeat.o(90750);
      }
    };
    AppMethodBeat.o(90754);
  }
  
  private static CharSequence G(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(90767);
    if (Util.getInt((String)paramMap.get(paramString + ".$hidden"), 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
      paramString = new SpannableString("");
      AppMethodBeat.o(90767);
      return paramString;
    }
    paramString = (String)paramMap.get(paramString + ".plain");
    paramString = new SpannableString(l.c(MMApplicationContext.getContext(), Util.nullAsNil(paramString)));
    AppMethodBeat.o(90767);
    return paramString;
  }
  
  private static void Q(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(90765);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && ((paramCharSequence instanceof Spanned)))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        int j = paramCharSequence.length;
        while (i < j)
        {
          if (!(paramCharSequence[i] instanceof com.tencent.mm.ui.base.span.a))
          {
            paramCharSequence = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
            AppMethodBeat.o(90765);
            throw paramCharSequence;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(90765);
  }
  
  private CharSequence a(Map<String, String> paramMap, Bundle paramBundle, WeakReference<Context> paramWeakReference, int paramInt, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(194496);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Object localObject2 = new StringBuilder();
    Object localObject1;
    label35:
    int j;
    if (i == 0)
    {
      localObject1 = "";
      localObject1 = localObject1;
      localObject1 = ".sysmsg.sysmsgtemplate.content_template" + (String)localObject1;
      if (paramMap.get(localObject1) == null) {
        break label877;
      }
      localObject2 = (String)paramMap.get((String)localObject1 + ".$type");
      if (!aFb((String)localObject2))
      {
        Log.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", new Object[] { localObject2 });
        localArrayList1.add(G((String)localObject1, paramMap));
      }
      if (paramBundle != null) {
        paramBundle.putString("template_type", (String)localObject2);
      }
      localObject1 = (String)paramMap.get((String)localObject1 + ".template");
      Log.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", new Object[] { localObject1 });
      localObject1 = c.aFd((String)localObject1);
      if (localObject1 != null) {
        break label287;
      }
      j = 0;
      label221:
      Log.d("MicroMsg.SysMsgTemplateImp", "hy: parsed %d models", new Object[] { Integer.valueOf(j) });
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label297;
      }
      localArrayList1.add(new SpannableString(""));
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label35;
      label287:
      j = ((ArrayList)localObject1).size();
      break label221;
      label297:
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala.type == 0)
        {
          localArrayList2.add(new SpannableString(l.c(MMApplicationContext.getContext(), locala.content)));
        }
        else if (locala.type == 1)
        {
          j = 0;
          localObject2 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
          localObject1 = localObject2;
          if (j != 0) {
            localObject1 = (String)localObject2 + j;
          }
          if ((String)paramMap.get(localObject1) != null)
          {
            localObject2 = (String)paramMap.get((String)localObject1 + ".$name");
            String str;
            label563:
            boolean bool;
            if (locala.content.equals(localObject2))
            {
              str = (String)paramMap.get((String)localObject1 + ".$type");
              if (paramInt != 0) {
                break label705;
              }
              localObject2 = (List)this.zqE.get(str);
              if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                break label639;
              }
              localObject2 = null;
              if ((aFc(str)) && (localObject2 != null)) {
                break label670;
              }
              str = Util.nullAs(str, "");
              if (localObject2 != null) {
                break label664;
              }
              bool = true;
              label593:
              Log.i("MicroMsg.SysMsgTemplateImp", "alvinluo not support link type: %s or listener == null: %b", new Object[] { str, Boolean.valueOf(bool) });
              localArrayList2.add(G((String)localObject1, paramMap));
            }
            label664:
            label670:
            label798:
            for (;;)
            {
              j += 1;
              break;
              label639:
              localObject2 = (e.b)((LinkedList)this.zqE.get(str)).getLast();
              break label563;
              bool = false;
              break label593;
              localObject1 = ((e.b)localObject2).a(paramMap, (String)localObject1, paramBundle, paramWeakReference, paramWeakReference1);
              Q((CharSequence)localObject1);
              localArrayList2.add(nullAsNil((CharSequence)localObject1));
              continue;
              label705:
              if (paramInt == 1)
              {
                localObject2 = (List)this.zqF.get(str);
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {}
                for (localObject2 = null;; localObject2 = (e.a)((LinkedList)this.zqF.get(str)).getLast())
                {
                  if ((aFc(str)) && (localObject2 != null)) {
                    break label798;
                  }
                  localArrayList2.add(G((String)localObject1, paramMap));
                  break;
                }
                localArrayList2.add(Util.nullAsNil(((e.a)localObject2).f(paramMap, (String)localObject1)));
              }
              else
              {
                Log.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
              }
            }
          }
        }
        else
        {
          Log.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
        }
      }
      localObject1 = concactSpannable(localArrayList2);
      Log.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", new Object[] { localObject1 });
      localArrayList1.add(localObject1);
    }
    label877:
    if (localArrayList1.size() == 0)
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
      paramMap = new SpannableString("");
      AppMethodBeat.o(194496);
      return paramMap;
    }
    paramMap = concactSpannable(localArrayList1);
    AppMethodBeat.o(194496);
    return paramMap;
  }
  
  private static boolean aFb(String paramString)
  {
    AppMethodBeat.i(90768);
    if (("tmpl_type_profile".equals(paramString)) || ("tmpl_type_profilewithrevoke".equals(paramString)) || ("tmpl_type_profilewithrevokeqrcode".equals(paramString)) || ("tmpl_type_wxappnotifywithview".equals(paramString)) || ("tmpl_type_succeed_contact".equals(paramString)) || ("tmpl_type_jump_chat".equals(paramString)) || ("tmpl_type_gamelife_link_url".equals(paramString)) || ("tmpl_type_gamelife_plain".equals(paramString)) || ("new_tmpl_type_succeed_contact".equals(paramString)) || ("tmpl_type_profilewithrevokeandunbindapp".equals(paramString)))
    {
      AppMethodBeat.o(90768);
      return true;
    }
    AppMethodBeat.o(90768);
    return false;
  }
  
  private static boolean aFc(String paramString)
  {
    AppMethodBeat.i(90769);
    if (("link_profile".equals(paramString)) || ("link_revoke".equals(paramString)) || ("link_revoke_qrcode".equals(paramString)) || ("link_plain".equals(paramString)) || ("link_view_wxapp".equals(paramString)) || ("link_succeed_contact".equals(paramString)) || ("link_jump_chat".equals(paramString)) || ("link_admin_explain".equals(paramString)) || ("new_link_succeed_contact".equals(paramString)) || ("link_live".equals(paramString)) || ("link_url".equals(paramString)) || ("comment_link_profile".equals(paramString)) || ("link_revoke_unbindapp".equals(paramString)) || ("link_history".equals(paramString)))
    {
      AppMethodBeat.o(90769);
      return true;
    }
    AppMethodBeat.o(90769);
    return false;
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(90766);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(90766);
    return paramArrayList;
  }
  
  private static CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(90764);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(90764);
      return paramCharSequence;
    }
    AppMethodBeat.o(90764);
    return paramCharSequence;
  }
  
  public final void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(90759);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", new Object[] { paramString });
    if (!this.zqF.containsKey(paramString)) {
      this.zqF.put(paramString, new LinkedList());
    }
    if (!((List)this.zqF.get(paramString)).contains(parama)) {
      ((LinkedList)this.zqF.get(paramString)).add(parama);
    }
    AppMethodBeat.o(90759);
  }
  
  public final void a(String paramString, e.b paramb)
  {
    AppMethodBeat.i(194492);
    if (!this.zqE.containsKey(paramString)) {
      this.zqE.put(paramString, new LinkedList());
    }
    List localList = (List)this.zqE.get(paramString);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s list=%s", new Object[] { paramString, localList });
    if ((localList != null) && (!localList.contains(paramb))) {
      ((LinkedList)this.zqE.get(paramString)).add(paramb);
    }
    AppMethodBeat.o(194492);
  }
  
  public final void a(final String paramString, final e.c paramc)
  {
    AppMethodBeat.i(194490);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90751);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", new Object[] { paramString });
        HashSet localHashSet2 = (HashSet)a.a(a.this).get(paramString);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null) {
          localHashSet1 = new HashSet();
        }
        if (!localHashSet1.contains(paramc)) {
          localHashSet1.add(paramc);
        }
        a.a(a.this).put(paramString, localHashSet1);
        AppMethodBeat.o(90751);
      }
    });
    AppMethodBeat.o(194490);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(194495);
    try
    {
      Object localObject = paramBundle.getString("template_type");
      localObject = (HashSet)this.zqG.get(localObject);
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.c)((Iterator)localObject).next()).b(paramString, paramMap, paramBundle);
        }
      }
      AppMethodBeat.o(194495);
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SysMsgTemplateImp", paramString, "", new Object[0]);
      AppMethodBeat.o(194495);
      return;
    }
  }
  
  public final void aDU(String paramString)
  {
    AppMethodBeat.i(194493);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", new Object[] { paramString });
    if (!this.zqE.containsKey(paramString)) {
      Log.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.zqE.get(paramString);
    if (localLinkedList == null)
    {
      Log.e("MicroMsg.SysMsgTemplateImp", "list is null!");
      AppMethodBeat.o(194493);
      return;
    }
    Log.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(194493);
  }
  
  public final void aDV(String paramString)
  {
    AppMethodBeat.i(90760);
    Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", new Object[] { paramString });
    if (!this.zqF.containsKey(paramString)) {
      Log.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.zqF.get(paramString);
    Log.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(90760);
  }
  
  public final CharSequence aDW(String paramString)
  {
    AppMethodBeat.i(90762);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
      AppMethodBeat.o(90762);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      Log.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
      AppMethodBeat.o(90762);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((Util.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(90762);
      return null;
    }
    paramString = a(paramString, null, null, 1, null);
    AppMethodBeat.o(90762);
    return paramString;
  }
  
  public final CharSequence b(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(194494);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
      AppMethodBeat.o(194494);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      Log.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
      AppMethodBeat.o(194494);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((Util.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      Log.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(194494);
      return null;
    }
    paramString = a(paramString, paramBundle, paramWeakReference, 0, paramWeakReference1);
    AppMethodBeat.o(194494);
    return paramString;
  }
  
  public final void b(final String paramString, final e.c paramc)
  {
    AppMethodBeat.i(194491);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90752);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", new Object[] { paramString });
        HashSet localHashSet = (HashSet)a.a(a.this).get(paramString);
        if (localHashSet == null)
        {
          AppMethodBeat.o(90752);
          return;
        }
        localHashSet.remove(paramc);
        if (localHashSet.size() == 0)
        {
          a.a(a.this).remove(paramString);
          AppMethodBeat.o(90752);
          return;
        }
        a.a(a.this).put(paramString, localHashSet);
        AppMethodBeat.o(90752);
      }
    });
    AppMethodBeat.o(194491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.a
 * JD-Core Version:    0.7.0.1
 */