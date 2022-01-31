package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class SeeRoomMemberUI$b
  extends BaseAdapter
{
  private List<SeeRoomMemberUI.a> cAs;
  private String eeu;
  private u efi;
  private List<String> ejc;
  public String ejd;
  private boolean eje;
  private String ejf;
  private List<SeeRoomMemberUI.a> ejg;
  private com.tencent.mm.plugin.messenger.foundation.a.j ejh;
  private Context mContext;
  
  public SeeRoomMemberUI$b(Context paramContext, u paramu, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(104326);
    this.eje = false;
    this.ejf = null;
    this.cAs = new ArrayList();
    this.efi = paramString1;
    this.eeu = paramList;
    this.ejc = paramString2;
    Object localObject;
    this.ejf = localObject;
    this.mContext = paramu;
    this.ejh = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class));
    N(n.nt(paramList));
    AppMethodBeat.o(104326);
  }
  
  private void ld(String paramString)
  {
    AppMethodBeat.i(104328);
    ArrayList localArrayList = new ArrayList();
    if (!bo.isNullOrNil(paramString))
    {
      Iterator localIterator = this.ejg.iterator();
      while (localIterator.hasNext())
      {
        SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
        if ((locala != null) && (locala.contact != null) && (locala.type == 1))
        {
          Object localObject = locala.contact;
          if ((((aq)localObject).field_conRemark != null) && (((aq)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
          {
            localArrayList.add(locala);
          }
          else if ((!bo.isNullOrNil(SeeRoomMemberUI.a(this.efi, ((aq)localObject).field_username))) && (SeeRoomMemberUI.a(this.efi, ((aq)localObject).field_username).contains(paramString)))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Oe() != null) && (((ad)localObject).Oe().toUpperCase().contains(paramString.toUpperCase())))
          {
            localArrayList.add(locala);
          }
          else if ((((ad)localObject).Ht() != null) && (((ad)localObject).Ht().toUpperCase().contains(paramString.toUpperCase())))
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
          else if (!com.tencent.mm.n.a.je(((aq)localObject).field_type))
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YB().TM(((aq)localObject).field_username);
            if ((localObject != null) && (((bv)localObject).field_conRemark != null) && (((bv)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
              localArrayList.add(locala);
            }
          }
        }
      }
      ab.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
    }
    for (this.cAs = localArrayList;; this.cAs = this.ejg)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(104328);
      return;
    }
  }
  
  public final void N(List<String> paramList)
  {
    AppMethodBeat.i(104327);
    if (paramList == null)
    {
      AppMethodBeat.o(104327);
      return;
    }
    this.cAs.clear();
    int i = 0;
    if (i < paramList.size())
    {
      ad localad = this.ejh.YA().arw((String)paramList.get(i));
      if (this.efi.ara(localad.field_username)) {
        this.cAs.add(new SeeRoomMemberUI.a(localad, 3));
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.efi.aqW(localad.field_username)) {
          this.cAs.add(new SeeRoomMemberUI.a(localad, 2));
        } else {
          this.cAs.add(new SeeRoomMemberUI.a(localad, 1));
        }
      }
    }
    Collections.sort(this.cAs, new SeeRoomMemberUI.b.1(this));
    this.cAs.add(new SeeRoomMemberUI.a(2));
    if (this.efi.JP()) {
      this.cAs.add(new SeeRoomMemberUI.a(3));
    }
    this.ejg = this.cAs;
    notifyDataSetChanged();
    AppMethodBeat.o(104327);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(104332);
    int i = this.cAs.size();
    AppMethodBeat.o(104332);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104330);
    View localView;
    SeeRoomMemberUI.c localc;
    String str;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2130970641, null);
      localc = new SeeRoomMemberUI.c((byte)0);
      localc.egq = ((ImageView)localView.findViewById(2131822799));
      localc.ejj = ((TextView)localView.findViewById(2131822801));
      paramView = (WindowManager)this.mContext.getSystemService("window");
      localc.ejj.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
      localc.ejk = ((TextView)localView.findViewById(2131827527));
      localView.setTag(localc);
      if (localc.ejk != null) {
        localc.ejk.setVisibility(8);
      }
      paramView = (SeeRoomMemberUI.a)this.cAs.get(paramInt);
      if ((paramView == null) || (paramView.type != 1)) {
        break label408;
      }
      ad localad = paramView.contact;
      a.b.c(localc.egq, localad.field_username);
      str = SeeRoomMemberUI.a(this.efi, localad.field_username);
      if (bo.isNullOrNil(localad.field_conRemark)) {
        break label381;
      }
      paramViewGroup = localad.field_conRemark;
      label216:
      paramView = paramViewGroup;
      if (bo.isNullOrNil(paramViewGroup)) {
        paramView = localad.Oe();
      }
      paramViewGroup = paramView;
      if (str != null)
      {
        paramViewGroup = paramView;
        if (!str.equals(""))
        {
          paramViewGroup = paramView;
          if (!paramView.equals(str)) {
            paramViewGroup = str + "( " + paramView + " )";
          }
        }
      }
      localc.ejj.setVisibility(0);
      localc.ejj.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramViewGroup, localc.ejj.getTextSize()));
      if (localc.ejk != null)
      {
        paramView = com.tencent.mm.openim.room.a.a.A(localad);
        if (!TextUtils.isEmpty(paramView)) {
          break label387;
        }
        localc.ejk.setVisibility(8);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104330);
      return localView;
      localc = (SeeRoomMemberUI.c)paramView.getTag();
      localView = paramView;
      break;
      label381:
      paramViewGroup = str;
      break label216;
      label387:
      localc.ejk.setVisibility(0);
      localc.ejk.setText(paramView);
      continue;
      label408:
      if ((paramView != null) && (paramView.type == 2))
      {
        localc.ejj.setVisibility(4);
        localc.egq.setImageResource(2130837890);
      }
      else if ((paramView != null) && (paramView.type == 3))
      {
        localc.ejj.setVisibility(4);
        localc.egq.setImageResource(2130837891);
      }
    }
  }
  
  public final SeeRoomMemberUI.a iC(int paramInt)
  {
    AppMethodBeat.i(104329);
    SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.cAs.get(paramInt);
    AppMethodBeat.o(104329);
    return locala;
  }
  
  public final void le(String paramString)
  {
    AppMethodBeat.i(104331);
    this.eje = true;
    this.ejd = paramString;
    ld(paramString);
    AppMethodBeat.o(104331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.b
 * JD-Core Version:    0.7.0.1
 */