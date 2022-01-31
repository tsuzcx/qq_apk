package com.tencent.mm.plugin.messenger.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private Map<String, LinkedList<e.b>> mdE = new HashMap();
  private Map<String, LinkedList<e.a>> mdF = new HashMap();
  private Map<String, HashSet<e.c>> mdG = new HashMap();
  private com.tencent.mm.as.a.d.a<Long, CharSequence> mdH = new com.tencent.mm.as.a.d.a(200);
  private com.tencent.mm.as.a.d.a<Long, CharSequence> mdI = new com.tencent.mm.as.a.d.a(500);
  public o mdJ = new a.1(this);
  
  private static boolean If(String paramString)
  {
    return ("link_profile".equals(paramString)) || ("link_revoke".equals(paramString)) || ("link_revoke_qrcode".equals(paramString)) || ("link_plain".equals(paramString)) || ("link_view_wxapp".equals(paramString)) || ("link_succeed_contact".equals(paramString)) || ("link_jump_chat".equals(paramString)) || ("link_admin_explain".equals(paramString));
  }
  
  private CharSequence a(Map<String, String> paramMap, Bundle paramBundle, WeakReference<Context> paramWeakReference, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Object localObject2 = new StringBuilder();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "";
      label30:
      localObject1 = localObject1;
      localObject1 = ".sysmsg.sysmsgtemplate.content_template" + (String)localObject1;
      if (bk.bl((String)paramMap.get(localObject1))) {
        break label955;
      }
      localObject2 = (String)paramMap.get((String)localObject1 + ".$type");
      if ((!"tmpl_type_profile".equals(localObject2)) && (!"tmpl_type_profilewithrevoke".equals(localObject2)) && (!"tmpl_type_profilewithrevokeqrcode".equals(localObject2)) && (!"tmpl_type_wxappnotifywithview".equals(localObject2)) && (!"tmpl_type_succeed_contact".equals(localObject2)) && (!"tmpl_type_jump_chat".equals(localObject2))) {
        break label336;
      }
      j = 1;
      label175:
      if (j == 0)
      {
        y.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", new Object[] { localObject2 });
        localArrayList1.add(m((String)localObject1, paramMap));
      }
      localObject1 = (String)paramMap.get((String)localObject1 + ".template");
      y.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", new Object[] { localObject1 });
      localObject1 = b.Ig((String)localObject1);
      if (localObject1 != null) {
        break label342;
      }
    }
    label336:
    label342:
    for (int j = 0;; j = ((ArrayList)localObject1).size())
    {
      y.d("MicroMsg.SysMsgTemplateImp", "hy: parsed %d models", new Object[] { Integer.valueOf(j) });
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label352;
      }
      localArrayList1.add(new SpannableString(""));
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label30;
      j = 0;
      break label175;
    }
    label352:
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    label647:
    label692:
    label717:
    label723:
    label987:
    label988:
    for (;;)
    {
      label368:
      b.a locala;
      if (localIterator.hasNext())
      {
        locala = (b.a)localIterator.next();
        if (locala.type == 0)
        {
          localArrayList2.add(new SpannableString(j.b(ae.getContext(), locala.content)));
          continue;
        }
        if (locala.type == 1)
        {
          j = 0;
          localObject1 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
          if (j == 0) {
            break label987;
          }
          localObject1 = (String)localObject1 + j;
        }
      }
      for (;;)
      {
        if (bk.bl((String)paramMap.get(localObject1))) {
          break label988;
        }
        localObject2 = (String)paramMap.get((String)localObject1 + ".$name");
        String str;
        label617:
        boolean bool;
        if (locala.content.equals(localObject2))
        {
          str = (String)paramMap.get((String)localObject1 + ".$type");
          if (paramInt != 0) {
            break label783;
          }
          localObject2 = (List)this.mdE.get(str);
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            break label692;
          }
          localObject2 = null;
          if ((If(str)) && (localObject2 != null)) {
            break label723;
          }
          str = bk.aM(str, "");
          if (localObject2 != null) {
            break label717;
          }
          bool = true;
          y.i("MicroMsg.SysMsgTemplateImp", "alvinluo not support link type: %s or listener == null: %b", new Object[] { str, Boolean.valueOf(bool) });
          localArrayList2.add(m((String)localObject1, paramMap));
        }
        for (;;)
        {
          j += 1;
          break;
          localObject2 = (e.b)((LinkedList)this.mdE.get(str)).getLast();
          break label617;
          bool = false;
          break label647;
          localObject2 = ((e.b)localObject2).a(paramMap, (String)localObject1, paramBundle, paramWeakReference);
          y((CharSequence)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((CharSequence)localObject2).length() != 0) {}
          }
          else
          {
            localObject1 = new SpannableString("");
          }
          localArrayList2.add(localObject1);
          continue;
          if (paramInt == 1)
          {
            localObject2 = (List)this.mdF.get(str);
            if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {}
            for (localObject2 = null;; localObject2 = (e.a)((LinkedList)this.mdF.get(str)).getLast())
            {
              if ((If(str)) && (localObject2 != null)) {
                break label876;
              }
              localArrayList2.add(m((String)localObject1, paramMap));
              break;
            }
            label876:
            localArrayList2.add(bk.pm(((e.a)localObject2).g(paramMap, (String)localObject1)));
          }
          else
          {
            y.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
          }
        }
        y.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
        break label368;
        localObject1 = concactSpannable(localArrayList2);
        y.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", new Object[] { localObject1 });
        localArrayList1.add(localObject1);
        break;
        if (localArrayList1.size() == 0)
        {
          y.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
          return new SpannableString("");
        }
        return concactSpannable(localArrayList1);
      }
    }
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    return paramArrayList;
  }
  
  private static CharSequence m(String paramString, Map<String, String> paramMap)
  {
    if (bk.getInt((String)paramMap.get(paramString + ".$hidden"), 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
      return new SpannableString("");
    }
    paramString = (String)paramMap.get(paramString + ".plain");
    return new SpannableString(j.b(ae.getContext(), bk.pm(paramString)));
  }
  
  private static void y(CharSequence paramCharSequence)
  {
    int i = 0;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && ((paramCharSequence instanceof Spanned)))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        int j = paramCharSequence.length;
        while (i < j)
        {
          if (!(paramCharSequence[i] instanceof com.tencent.mm.ui.base.a.a)) {
            throw new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
          }
          i += 1;
        }
      }
    }
  }
  
  public final void Hb(String paramString)
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", new Object[] { paramString });
    if (!this.mdE.containsKey(paramString)) {
      y.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.mdE.get(paramString);
    y.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
  }
  
  public final void Hc(String paramString)
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", new Object[] { paramString });
    if (!this.mdF.containsKey(paramString)) {
      y.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.mdF.get(paramString);
    y.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
  }
  
  public final CharSequence Hd(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
      return null;
    }
    paramString = bn.s(paramString, "sysmsg");
    if (paramString == null)
    {
      y.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((bk.bl(str)) || (!"sysmsgtemplate".equals(str)))
    {
      y.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", new Object[] { str });
      return null;
    }
    return a(paramString, null, null, 1);
  }
  
  public final CharSequence a(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
      return null;
    }
    paramString = bn.s(paramString, "sysmsg");
    if (paramString == null)
    {
      y.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((bk.bl(str)) || (!"sysmsgtemplate".equals(str)))
    {
      y.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", new Object[] { str });
      return null;
    }
    return a(paramString, paramBundle, paramWeakReference, 0);
  }
  
  public final void a(String paramString, e.a parama)
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", new Object[] { paramString });
    if (!this.mdF.containsKey(paramString)) {
      this.mdF.put(paramString, new LinkedList());
    }
    if (!((List)this.mdF.get(paramString)).contains(parama)) {
      ((LinkedList)this.mdF.get(paramString)).add(parama);
    }
  }
  
  public final void a(String paramString, e.b paramb)
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", new Object[] { paramString });
    if (!this.mdE.containsKey(paramString)) {
      this.mdE.put(paramString, new LinkedList());
    }
    if (!((List)this.mdE.get(paramString)).contains(paramb)) {
      ((LinkedList)this.mdE.get(paramString)).add(paramb);
    }
  }
  
  public final void a(String paramString, e.c paramc)
  {
    ai.d(new a.2(this, paramString, paramc));
  }
  
  public final void b(String paramString, e.c paramc)
  {
    ai.d(new a.3(this, paramString, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */