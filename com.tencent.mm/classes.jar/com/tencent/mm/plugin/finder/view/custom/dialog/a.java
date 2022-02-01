package com.tencent.mm.plugin.finder.view.custom.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.a.a;
import com.tencent.mm.ui.widget.a.e.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements y
{
  private static int[] GGM = { e.e.title_image_0, e.e.title_image_1, e.e.title_image_2, e.e.title_image_3, e.e.title_image_4, e.e.title_image_5, e.e.title_image_6, e.e.title_image_7, e.e.title_image_8 };
  
  private static View c(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(345009);
    paramContext = View.inflate(paramContext, e.f.confirm_dialog_title_multi_image, null);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((i > 8) || (paramContext == null)) {
          break label102;
        }
        ImageView localImageView = (ImageView)paramContext.findViewById(GGM[i]);
        if (str == null) {
          break label102;
        }
        localImageView.setVisibility(0);
        com.tencent.mm.ui.i.a.a.g(localImageView, str);
        i += 1;
      }
    }
    label102:
    for (;;)
    {
      break;
      AppMethodBeat.o(345009);
      return paramContext;
    }
  }
  
  public static final class a
  {
    private final e.a GGP;
    private String GGQ;
    Context mContext;
    public e pRv;
    private DialogInterface.OnDismissListener uBy;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(345006);
      this.GGQ = null;
      this.mContext = paramContext;
      this.GGP = new e.a(this.mContext);
      this.GGP.NC(false);
      this.GGP.ND(false);
      this.GGP.a(new a.a.1(this));
      AppMethodBeat.o(345006);
    }
    
    public final a UL(int paramInt)
    {
      AppMethodBeat.i(345042);
      this.GGQ = this.mContext.getResources().getString(paramInt);
      AppMethodBeat.o(345042);
      return this;
    }
    
    public final a a(y.a parama)
    {
      AppMethodBeat.i(345049);
      this.pRv = this.GGP.jHH();
      if (this.uBy != null) {
        this.pRv.setOnDismissListener(this.uBy);
      }
      a.a(this.mContext, this.pRv, this.GGQ, parama, parama);
      AppMethodBeat.o(345049);
      return this;
    }
    
    public final a aCJ(String paramString)
    {
      AppMethodBeat.i(345021);
      int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cd.a.getScaleSize(this.mContext)));
      if (!Util.isNullOrNil(paramString))
      {
        paramString = ((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(this.mContext, paramString.toString(), i);
        this.GGP.be(paramString);
      }
      AppMethodBeat.o(345021);
      return this;
    }
    
    public final a fI(Object paramObject)
    {
      AppMethodBeat.i(345016);
      a.a(this.mContext, this.GGP, paramObject);
      this.GGP.NA(true);
      AppMethodBeat.o(345016);
      return this;
    }
    
    public final a flU()
    {
      AppMethodBeat.i(345034);
      this.GGP.NA(false);
      AppMethodBeat.o(345034);
      return this;
    }
    
    public final a hg(View paramView)
    {
      AppMethodBeat.i(345027);
      this.GGP.md(paramView);
      AppMethodBeat.o(345027);
      return this;
    }
    
    public final a x(Boolean paramBoolean)
    {
      AppMethodBeat.i(345031);
      this.GGP.NB(paramBoolean.booleanValue());
      if (paramBoolean.booleanValue()) {
        this.GGP.bDA(this.mContext.getString(e.h.confirm_dialog_edittext_hint));
      }
      AppMethodBeat.o(345031);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.custom.dialog.a
 * JD-Core Version:    0.7.0.1
 */