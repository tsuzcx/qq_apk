package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.List;

public final class GroupToolsManagereUI$e
  extends RecyclerView.a
{
  private Context context;
  private boolean frW;
  boolean frX = true;
  private List<GroupToolItem> frY;
  private GroupToolsManagereUI.c frZ;
  
  public GroupToolsManagereUI$e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
  {
    this.context = paramContext;
    this.frW = paramBoolean;
    this.frY = paramList;
    this.frZ = paramc;
  }
  
  private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(182188);
    com.tencent.mm.aw.a.a locala = o.ayJ();
    Object localObject;
    if (paramWxaAttributes != null)
    {
      localObject = paramWxaAttributes.field_smallHeadURL;
      locala.a((String)localObject, paramd.frR, GroupToolsManagereUI.d.frV);
      localObject = paramd.frS;
      if (paramWxaAttributes == null) {
        break label61;
      }
    }
    label61:
    for (paramd = paramWxaAttributes.field_nickname;; paramd = "")
    {
      ((TextView)localObject).setText(paramd);
      AppMethodBeat.o(182188);
      return;
      localObject = "";
      break;
    }
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(182186);
    paramViewGroup = new GroupToolsManagereUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493380, paramViewGroup, false));
    AppMethodBeat.o(182186);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(182187);
    if ((this.frY != null) && (paramInt >= 0) && (paramInt < this.frY.size()))
    {
      paramv = (GroupToolsManagereUI.d)paramv;
      GroupToolItem localGroupToolItem = (GroupToolItem)this.frY.get(paramInt);
      ad.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
      paramv.frN.setVisibility(0);
      if (this.frW)
      {
        paramv.frP.setVisibility(8);
        paramv.frQ.setVisibility(0);
        paramv.frT.setVisibility(0);
        if (!localGroupToolItem.Va()) {
          break label247;
        }
        paramv.frR.setImageResource(2131232617);
        paramv.frS.setText(2131757070);
        label131:
        if (!this.frX) {
          break label344;
        }
        paramv.frN.setAlpha(1.0F);
      }
      for (;;)
      {
        ((ViewGroup)paramv.frO.getParent()).setTag(Boolean.valueOf(this.frW));
        paramv.frO.setTag(localGroupToolItem);
        paramv.frO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182184);
            if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramAnonymousView, paramv.ln());
            }
            AppMethodBeat.o(182184);
          }
        });
        if (!this.frW) {
          break label357;
        }
        paramv.frT.setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182185);
            GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramv);
            paramv.frT.performHapticFeedback(0, 2);
            AppMethodBeat.o(182185);
            return true;
          }
        });
        AppMethodBeat.o(182187);
        return;
        paramv.frP.setVisibility(0);
        paramv.frQ.setVisibility(8);
        paramv.frT.setVisibility(4);
        break;
        label247:
        if (localGroupToolItem.ccm())
        {
          paramv.frP.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691535));
          paramv.frS.setText(2131756264);
          break label131;
        }
        WxaAttributes localWxaAttributes = ((m)g.ab(m.class)).FW(localGroupToolItem.username);
        if (localWxaAttributes == null)
        {
          ((m)g.ab(m.class)).a(localGroupToolItem.username, new m.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(182183);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(182182);
                  GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.fsa, paramAnonymousWxaAttributes);
                  AppMethodBeat.o(182182);
                }
              });
              AppMethodBeat.o(182183);
            }
          });
          break label131;
        }
        a(paramv, localWxaAttributes);
        break label131;
        label344:
        paramv.frN.setAlpha(0.3F);
      }
      label357:
      paramv.frT.setOnLongClickListener(null);
    }
    AppMethodBeat.o(182187);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(182189);
    int i = this.frY.size();
    AppMethodBeat.o(182189);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.e
 * JD-Core Version:    0.7.0.1
 */