package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class SelectMemberUI$b
  extends BaseAdapter
{
  private List<SelectMemberUI.a> cAs;
  private u efi;
  private String egF;
  public final String ejM;
  HashMap<String, Integer> ejN;
  public String ejd;
  private String ejf;
  private List<SelectMemberUI.a> ejg;
  volatile boolean isLoading;
  private Context mContext;
  
  public SelectMemberUI$b(SelectMemberUI paramSelectMemberUI, Context paramContext, u paramu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104419);
    this.ejM = new String(Character.toChars(91));
    this.ejf = null;
    this.ejg = new ArrayList(0);
    this.cAs = new ArrayList();
    this.isLoading = false;
    this.ejN = new HashMap();
    this.efi = paramu;
    this.egF = paramString1;
    this.ejf = paramString2;
    this.mContext = paramContext;
    AppMethodBeat.o(104419);
  }
  
  private String c(ad paramad)
  {
    AppMethodBeat.i(104424);
    String str1;
    if (!bo.isNullOrNil(paramad.field_conRemark))
    {
      str1 = paramad.field_conRemark;
      if (!bo.isNullOrNil(str1)) {
        break label112;
      }
      str1 = paramad.Oe();
    }
    label112:
    for (;;)
    {
      String str2 = str1;
      if (!a.je(paramad.field_type))
      {
        paramad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YB().TM(paramad.field_username);
        str2 = str1;
        if (paramad != null)
        {
          str2 = str1;
          if (!bo.isNullOrNil(paramad.field_conRemark)) {
            str2 = paramad.field_conRemark;
          }
        }
      }
      AppMethodBeat.o(104424);
      return str2;
      str1 = SelectMemberUI.a(this.efi, paramad.field_username);
      break;
    }
  }
  
  public final void N(List<String> paramList)
  {
    AppMethodBeat.i(104425);
    if (paramList == null)
    {
      AppMethodBeat.o(104425);
      return;
    }
    this.cAs.clear();
    int i = 0;
    if (i < paramList.size())
    {
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)paramList.get(i));
      if ((this.ejJ.Kf()) || (!r.nB(localad.field_username)))
      {
        boolean bool = localad.field_username.equals(this.ejf);
        if (((!bool) || (SelectMemberUI.e(this.ejJ))) && (!this.ejJ.Kn().contains(localad.field_username)))
        {
          if ((!bool) || (!SelectMemberUI.e(this.ejJ))) {
            break label176;
          }
          this.cAs.add(0, new SelectMemberUI.a(this.ejJ, localad));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label176:
        this.cAs.add(new SelectMemberUI.a(this.ejJ, localad));
      }
    }
    Collections.sort(this.cAs, new SelectMemberUI.b.6(this));
    this.ejg = this.cAs;
    AppMethodBeat.o(104425);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(104421);
    if ((this.cAs == null) || (this.isLoading))
    {
      AppMethodBeat.o(104421);
      return 0;
    }
    int i = this.cAs.size();
    AppMethodBeat.o(104421);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104423);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130970656, null);
      paramViewGroup = new SelectMemberUI.c();
      paramViewGroup.ejS = ((MaskLayout)paramView.findViewById(2131827541));
      paramViewGroup.ejj = ((EllipsizeTextView)paramView.findViewById(2131827542));
      paramViewGroup.ejj = ((TextView)paramView.findViewById(2131827542));
      paramViewGroup.ejU = ((ImageButton)paramView.findViewById(2131822803));
      paramViewGroup.ejV = ((LinearLayout)paramView.findViewById(2131827544));
      localObject = (WindowManager)this.mContext.getSystemService("window");
      paramViewGroup.ejj.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
      paramViewGroup.ejT = ((TextView)paramView.findViewById(2131827543));
      paramViewGroup.ejT.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
      paramView.setTag(paramViewGroup);
      paramViewGroup.ejU.setOnClickListener(new SelectMemberUI.b.3(this, paramViewGroup));
      paramViewGroup.ejV.setOnClickListener(new SelectMemberUI.b.4(this, paramViewGroup));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104417);
          SelectMemberUI.c localc = (SelectMemberUI.c)paramAnonymousView.getTag();
          SelectMemberUI.b.this.ejJ.a(paramAnonymousView, localc.position, paramAnonymousView.getId());
          AppMethodBeat.o(104417);
        }
      });
    }
    SelectMemberUI.a locala;
    for (;;)
    {
      locala = iD(paramInt);
      paramViewGroup.ejV.setTag(Integer.valueOf(paramInt));
      if (locala != null) {
        break;
      }
      ab.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      AppMethodBeat.o(104423);
      return paramView;
      paramViewGroup = (SelectMemberUI.c)paramView.getTag();
    }
    ad localad = locala.contact;
    a.b.c((ImageView)paramViewGroup.ejS.getContentView(), localad.field_username);
    String str;
    if (localad.field_verifyFlag != 0) {
      if (ao.a.flK != null)
      {
        localObject = ao.a.flK.ky(localad.field_verifyFlag);
        if (localObject != null)
        {
          localObject = com.tencent.mm.aj.m.sf((String)localObject);
          paramViewGroup.ejS.a((Bitmap)localObject, MaskLayout.a.znW);
          str = c(localad);
          localObject = "";
          if (a.je(localad.field_type)) {
            localObject = localad.dqT;
          }
          if (bo.isNullOrNil((String)localObject)) {
            break label614;
          }
          paramViewGroup.ejT.setVisibility(0);
          paramViewGroup.ejT.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject, paramViewGroup.ejT.getTextSize()));
          label439:
          if (!ad.arf(localad.field_username)) {
            break label635;
          }
          ((b)g.E(b.class)).a(this.mContext, paramViewGroup.ejj, str, localad.field_openImAppid, localad.field_descWordingId, (int)paramViewGroup.ejj.getTextSize());
          label492:
          if (!this.ejJ.Kk()) {
            break label724;
          }
          paramViewGroup.ejU.setVisibility(0);
          paramViewGroup.ejV.setVisibility(0);
          if (!this.ejJ.Kl().contains(localad.field_username)) {
            break label661;
          }
          paramViewGroup.ejV.setEnabled(false);
          paramViewGroup.ejU.setEnabled(false);
          paramViewGroup.ejU.setImageResource(2131231139);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.ejR = locala;
      paramViewGroup.position = paramInt;
      AppMethodBeat.o(104423);
      return paramView;
      paramViewGroup.ejS.setMaskDrawable(null);
      break;
      paramViewGroup.ejS.setMaskDrawable(null);
      break;
      paramViewGroup.ejS.setMaskDrawable(null);
      break;
      label614:
      paramViewGroup.ejT.setVisibility(8);
      paramViewGroup.ejT.setText("");
      break label439;
      label635:
      paramViewGroup.ejj.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, str, paramViewGroup.ejj.getTextSize()));
      break label492;
      label661:
      paramViewGroup.ejV.setEnabled(true);
      paramViewGroup.ejU.setEnabled(true);
      if (this.ejJ.ejG.contains(locala.contact.field_username))
      {
        paramViewGroup.ejU.setImageResource(2131231137);
      }
      else
      {
        paramViewGroup.ejU.setImageResource(2131231142);
        continue;
        label724:
        paramViewGroup.ejU.setVisibility(8);
        paramViewGroup.ejV.setVisibility(8);
      }
    }
  }
  
  public final SelectMemberUI.a iD(int paramInt)
  {
    AppMethodBeat.i(104422);
    if (this.cAs.size() > paramInt)
    {
      SelectMemberUI.a locala = (SelectMemberUI.a)this.cAs.get(paramInt);
      AppMethodBeat.o(104422);
      return locala;
    }
    AppMethodBeat.o(104422);
    return null;
  }
  
  public final void ld(String paramString)
  {
    AppMethodBeat.i(104420);
    ab.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
    ArrayList localArrayList = new ArrayList();
    if (!bo.isNullOrNil(paramString))
    {
      Iterator localIterator = this.ejg.iterator();
      while (localIterator.hasNext())
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
        if ((locala != null) && (locala.contact != null) && (locala.type == 1))
        {
          Object localObject = locala.contact;
          if ((((aq)localObject).field_conRemark != null) && (((aq)localObject).field_conRemark.contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((!bo.isNullOrNil(SeeRoomMemberUI.a(this.efi, ((aq)localObject).field_username))) && (SeeRoomMemberUI.a(this.efi, ((aq)localObject).field_username).contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Oe() != null) && (((ad)localObject).Oe().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Ht() != null) && (((ad)localObject).Ht().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Hq() != null) && (((ad)localObject).Hq().contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((aq)localObject).field_username != null) && (((aq)localObject).field_username.contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if (!a.je(((aq)localObject).field_type))
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YB().TM(((aq)localObject).field_username);
            if ((localObject != null) && (((bv)localObject).field_conRemark != null) && (((bv)localObject).field_conRemark.contains(paramString))) {
              localArrayList.add(locala);
            }
          }
        }
      }
      this.cAs = localArrayList;
      AppMethodBeat.o(104420);
      return;
    }
    this.cAs = this.ejg;
    AppMethodBeat.o(104420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b
 * JD-Core Version:    0.7.0.1
 */