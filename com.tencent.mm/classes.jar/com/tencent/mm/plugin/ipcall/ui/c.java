package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends v<com.tencent.mm.plugin.ipcall.model.h.c>
  implements f.a
{
  static HashMap<String, com.tencent.mm.plugin.ipcall.model.h.c> DSH = null;
  private d DTG;
  private HashMap<Long, com.tencent.mm.plugin.ipcall.model.h.c> DTH;
  private HashSet<String> DTI;
  private boolean DTJ;
  private View.OnClickListener DTK;
  HashMap<String, Integer> jkO;
  private Context mContext;
  private String mUI;
  PhoneFormater nii;
  boolean sxF;
  
  public c(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(25613);
    this.DTH = new HashMap();
    this.jkO = new HashMap();
    this.DTI = new HashSet();
    this.DTJ = false;
    this.sxF = false;
    this.DTK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25611);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getTag() instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          localObject = c.this.Vp(i);
          paramAnonymousView = new Intent(c.a(c.this), IPCallUserProfileUI.class);
          paramAnonymousView.putExtra("IPCallProfileUI_contactid", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_contactId);
          paramAnonymousView.putExtra("IPCallProfileUI_systemUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_systemAddressBookUsername);
          paramAnonymousView.putExtra("IPCallProfileUI_wechatUsername", ((com.tencent.mm.plugin.ipcall.model.h.c)localObject).field_wechatUsername);
          localObject = c.b(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25611);
      }
    };
    this.nii = new PhoneFormater();
    Fx(true);
    this.mContext = paramContext;
    this.DTG = new d(paramContext);
    q.bhz().a(this);
    AppMethodBeat.o(25613);
  }
  
  private static String a(com.tencent.mm.plugin.ipcall.model.h.c paramc, String paramString)
  {
    AppMethodBeat.i(25622);
    if ((paramc != null) && (paramc.DSI != null))
    {
      paramc = paramc.DSI.iterator();
      while (paramc.hasNext())
      {
        String str = (String)paramc.next();
        if (str.contains(paramString))
        {
          AppMethodBeat.o(25622);
          return str;
        }
      }
    }
    AppMethodBeat.o(25622);
    return null;
  }
  
  private static String aMo(String paramString)
  {
    AppMethodBeat.i(25623);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25623);
      return "";
    }
    if (paramString.startsWith(com.tencent.mm.plugin.ipcall.model.h.b.jkN))
    {
      AppMethodBeat.o(25623);
      return "#";
    }
    paramString = paramString.toUpperCase().substring(0, 1);
    AppMethodBeat.o(25623);
    return paramString;
  }
  
  private void eKe()
  {
    AppMethodBeat.i(25628);
    if (hK() != null)
    {
      Cursor localCursor = hK();
      Object localObject1 = null;
      try
      {
        if (!localCursor.moveToFirst()) {
          break label153;
        }
        int i = 0;
        if (localCursor.isAfterLast()) {
          break label153;
        }
        Object localObject2 = new com.tencent.mm.plugin.ipcall.model.h.c();
        ((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).convertFrom(localCursor);
        localObject2 = aMo(((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).field_sortKey);
        if (i == 0) {
          this.jkO.put(localObject2, Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          localCursor.moveToNext();
          localObject1 = localObject2;
          break;
          if ((localObject1 != null) && (!((String)localObject2).equals(localObject1))) {
            this.jkO.put(localObject2, Integer.valueOf(i));
          }
        }
        AppMethodBeat.o(25628);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[] { localException.getMessage() });
      }
    }
    else
    {
      return;
    }
    label153:
    AppMethodBeat.o(25628);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(25626);
    if (this.DTI.contains(paramString)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25612);
          c.this.notifyDataSetChanged();
          AppMethodBeat.o(25612);
        }
      });
    }
    AppMethodBeat.o(25626);
  }
  
  public final com.tencent.mm.plugin.ipcall.model.h.c Vp(int paramInt)
  {
    AppMethodBeat.i(25616);
    com.tencent.mm.plugin.ipcall.model.h.c localc = (com.tencent.mm.plugin.ipcall.model.h.c)super.getItem(paramInt);
    AppMethodBeat.o(25616);
    return localc;
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(25617);
    this.mUI = paramString;
    if (Util.isNullOrNil(this.mUI)) {}
    for (this.DTJ = false;; this.DTJ = true)
    {
      this.VZb.clear();
      atr();
      notifyDataSetChanged();
      AppMethodBeat.o(25617);
      return;
    }
  }
  
  public final void atr()
  {
    AppMethodBeat.i(25618);
    Cursor localCursor;
    if (!this.DTJ) {
      localCursor = i.eJw().eJX();
    }
    for (;;)
    {
      if (localCursor != null) {
        localCursor.moveToFirst();
      }
      v(localCursor);
      eKe();
      AppMethodBeat.o(25618);
      return;
      this.sxF = true;
      localCursor = i.eJw().aMe(this.mUI);
      this.sxF = false;
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(25620);
    super.eKd();
    atr();
    AppMethodBeat.o(25620);
  }
  
  public final int eKc()
  {
    AppMethodBeat.i(25615);
    int i = super.getCount();
    AppMethodBeat.o(25615);
    return i;
  }
  
  public final void eKd()
  {
    AppMethodBeat.i(25619);
    super.eKd();
    AppMethodBeat.o(25619);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25614);
    int i = super.getCount();
    AppMethodBeat.o(25614);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(25624);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(25624);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25621);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(R.i.ehX, paramViewGroup, false);
      paramView = new b((byte)0);
      paramView.DTW = localView.findViewById(R.h.dKh);
      paramView.DTX = localView.findViewById(R.h.divider_bottom);
      paramView.jiu = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.mUy = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramView.DTO = ((TextView)localView.findViewById(R.h.dRd));
      paramView.DTP = ((LinearLayout)localView.findViewById(R.h.dSh));
      paramView.DTQ = ((TextView)localView.findViewById(R.h.dSi));
      paramView.DTR = ((TextView)localView.findViewById(R.h.dSj));
      paramView.DTS = ((TextView)localView.findViewById(R.h.dqA));
      paramView.DTT = ((TextView)localView.findViewById(R.h.dqt));
      paramView.DTU = ((ImageView)localView.findViewById(R.h.dqu));
      paramView.DTV = localView.findViewById(R.h.dKi);
      paramView.DTV.setClickable(true);
      paramView.DTY = ((ImageView)localView.findViewById(R.h.divider));
      localView.setTag(paramView);
    }
    paramViewGroup = (b)localView.getTag();
    paramViewGroup.DTV.setClickable(true);
    paramViewGroup.DTV.setTag(Integer.valueOf(paramInt));
    paramViewGroup.DTY.setVisibility(8);
    int j;
    int i;
    if (TR(paramInt))
    {
      paramViewGroup.mUy.setVisibility(8);
      paramViewGroup.DTO.setVisibility(8);
      paramViewGroup.DTP.setVisibility(8);
      paramViewGroup.jiu.setVisibility(8);
      paramViewGroup.jiu.setTag(null);
      paramViewGroup.DTT.setVisibility(8);
      paramViewGroup.DTS.setVisibility(8);
      paramViewGroup.DTU.setVisibility(8);
      j = 1;
      i = j;
      if (Vp(paramInt + 1) != null)
      {
        i = j;
        if (Vp(paramInt) != null)
        {
          i = j;
          if (!aMo(Vp(paramInt + 1).field_sortKey).equals(aMo(Vp(paramInt).field_sortKey))) {
            i = 0;
          }
        }
      }
      if ((paramInt + 1 != getCount()) && (i != 0)) {
        break label1583;
      }
      paramViewGroup.DTX.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(25621);
      return localView;
      com.tencent.mm.plugin.ipcall.model.h.c localc = Vp(paramInt);
      if (localc != null)
      {
        if (Util.isNullOrNil(localc.field_systemAddressBookUsername)) {
          break label1430;
        }
        paramViewGroup.mUy.setVisibility(0);
        if (!this.DTJ) {
          break label919;
        }
        paramViewGroup.DTO.setVisibility(0);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.DTW.getLayoutParams();
        paramView.height = ((int)paramViewGroup.DTO.getContext().getResources().getDimension(R.f.dlc));
        paramViewGroup.DTW.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.jiu.getLayoutParams();
        paramView.height = ((int)paramViewGroup.jiu.getContext().getResources().getDimension(R.f.dkZ));
        paramView.width = ((int)paramViewGroup.jiu.getContext().getResources().getDimension(R.f.dkZ));
        paramViewGroup.jiu.setLayoutParams(paramView);
        label602:
        if ((!this.DTJ) || (localc.DSI != null) || (DSH == null) || (!DSH.containsKey(localc.field_contactId))) {
          break label1032;
        }
        localc.DSI = ((com.tencent.mm.plugin.ipcall.model.h.c)DSH.get(localc.field_contactId)).DSI;
        label659:
        if ((Util.isNullOrNil(this.mUI)) || ((!Util.isNum(this.mUI.charAt(0))) && (!this.mUI.startsWith("+")))) {
          break label1083;
        }
        paramView = com.tencent.mm.plugin.fts.a.f.b(a(localc, this.mUI), PhoneFormater.formatMobileString(this.mUI));
        paramViewGroup.DTO.setText(paramView);
        paramView = com.tencent.mm.plugin.fts.a.f.b(localc.field_systemAddressBookUsername, this.mUI);
        paramViewGroup.mUy.setText(paramView);
        label745:
        paramView = paramViewGroup.jiu;
        if (paramView != null)
        {
          paramView.setVisibility(0);
          paramView.setTag(null);
          paramView.setImageResource(R.g.dnG);
          if (localc != null)
          {
            if ((Util.isNullOrNil(localc.field_contactId)) || (Util.isNullOrNil(localc.field_wechatUsername))) {
              break label1451;
            }
            this.DTG.a(localc.field_contactId, localc.field_wechatUsername, paramView);
            label816:
            if (!Util.isNullOrNil(localc.field_wechatUsername)) {
              this.DTI.add(localc.field_wechatUsername);
            }
          }
        }
        paramViewGroup.DTP.setVisibility(8);
        paramView = aMo(localc.field_sortKey);
        if (paramInt != 0) {
          break label1505;
        }
        paramViewGroup.DTS.setVisibility(0);
        paramViewGroup.DTS.setText(paramView);
        paramViewGroup.DTT.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.DTV.setVisibility(8);
        paramViewGroup.DTU.setVisibility(8);
        paramViewGroup.DTU.setOnClickListener(this.DTK);
        break;
        label919:
        paramViewGroup.DTO.setVisibility(8);
        paramView = (FrameLayout.LayoutParams)paramViewGroup.DTW.getLayoutParams();
        paramView.height = ((int)paramViewGroup.DTO.getContext().getResources().getDimension(R.f.dlb));
        paramViewGroup.DTW.setLayoutParams(paramView);
        paramView = (RelativeLayout.LayoutParams)paramViewGroup.jiu.getLayoutParams();
        paramView.height = ((int)paramViewGroup.jiu.getContext().getResources().getDimension(R.f.dla));
        paramView.width = ((int)paramViewGroup.jiu.getContext().getResources().getDimension(R.f.dla));
        paramViewGroup.jiu.setLayoutParams(paramView);
        break label602;
        label1032:
        if ((!this.DTJ) || (localc.DSI != null) || ((DSH != null) && (!DSH.containsKey(localc.field_contactId)))) {
          break label659;
        }
        localc.DSI = com.tencent.mm.plugin.ipcall.model.h.b.aMb(localc.field_contactId);
        break label659;
        label1083:
        if ((!Util.isNullOrNil(this.mUI)) && (!Util.isNum(this.mUI.charAt(0))))
        {
          String str1 = localc.field_systemAddressBookUsername;
          Object localObject = localc.field_systemAddressBookUsername;
          paramView = this.mUI;
          if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil((String)localObject))) {
            paramView = "";
          }
          label1402:
          for (;;)
          {
            paramView = com.tencent.mm.plugin.fts.a.f.b(str1, paramView);
            paramViewGroup.mUy.setText(paramView);
            paramViewGroup.DTO.setText(a(localc, this.mUI));
            break;
            if ((!Util.isChinese(paramView)) && (Util.isAllAlpha(paramView)))
            {
              ArrayList localArrayList = new ArrayList();
              i = 0;
              String str2;
              while (i < ((String)localObject).length())
              {
                str2 = ((String)localObject).substring(i, i + 1);
                localArrayList.add(new a(com.tencent.mm.platformtools.f.ZJ(str2), str2));
                i += 1;
              }
              i = 2;
              while (i <= ((String)localObject).length())
              {
                j = 0;
                while (j <= ((String)localObject).length() - i)
                {
                  str2 = ((String)localObject).substring(j, j + i);
                  localArrayList.add(new a(com.tencent.mm.platformtools.f.ZJ(str2), str2));
                  j += 1;
                }
                i += 1;
              }
              i = 0;
              for (;;)
              {
                if (i >= localArrayList.size()) {
                  break label1402;
                }
                localObject = (a)localArrayList.get(i);
                if (((a)localObject).DTM.contains(paramView))
                {
                  paramView = ((a)localObject).DTN;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        if (!Util.isNullOrNil(this.mUI)) {
          break label745;
        }
        paramViewGroup.mUy.setText(localc.field_systemAddressBookUsername);
        break label745;
        label1430:
        paramViewGroup.mUy.setVisibility(8);
        paramViewGroup.DTO.setVisibility(8);
        break label745;
        label1451:
        if (!Util.isNullOrNil(localc.field_contactId))
        {
          this.DTG.d(localc.field_contactId, paramView);
          break label816;
        }
        if (Util.isNullOrNil(localc.field_wechatUsername)) {
          break label816;
        }
        this.DTG.f(localc.field_wechatUsername, paramView);
        break label816;
        label1505:
        if (!aMo(Vp(paramInt - 1).field_sortKey).equals(paramView))
        {
          paramViewGroup.DTS.setVisibility(0);
          paramViewGroup.DTS.setText(paramView);
          paramViewGroup.DTT.setVisibility(8);
        }
        else
        {
          paramViewGroup.DTS.setVisibility(8);
          paramViewGroup.DTS.setText("");
          paramViewGroup.DTT.setVisibility(8);
        }
      }
      label1583:
      paramViewGroup.DTX.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(25625);
    int i = super.getViewTypeCount();
    AppMethodBeat.o(25625);
    return i;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(25627);
    this.DTH.clear();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25627);
  }
  
  final class a
  {
    String DTM;
    String DTN;
    
    public a(String paramString1, String paramString2)
    {
      this.DTN = paramString2;
      this.DTM = paramString1;
    }
  }
  
  final class b
  {
    TextView DTO;
    LinearLayout DTP;
    TextView DTQ;
    TextView DTR;
    TextView DTS;
    TextView DTT;
    ImageView DTU;
    View DTV;
    View DTW;
    View DTX;
    ImageView DTY;
    ImageView jiu;
    TextView mUy;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c
 * JD-Core Version:    0.7.0.1
 */