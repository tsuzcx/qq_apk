package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ap
  extends ai
{
  public View clickArea;
  public MMNeat7extView sDe;
  public TextView sHK;
  
  public final View b(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6042);
    super.a(paramContext, paramb);
    if (this.sEi != null)
    {
      paramContext = this.sEi;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.sEi = View.inflate(paramContext, d.f.stZ, null);
    cAQ();
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(d.e.srk));
    this.sHK = ((TextView)this.sEi.findViewById(d.e.srl));
    this.sDe.setOnTouchListener(new h(this.sDe, new o(this.sDe.getContext())));
    this.clickArea = this.sEi.findViewById(d.e.sqK);
    paramContext = this.sEi;
    AppMethodBeat.o(6042);
    return paramContext;
  }
  
  public final View b(final z paramz, int paramInt, View paramView)
  {
    AppMethodBeat.i(265200);
    Context localContext = this.mContext;
    String str = paramz.field_content;
    int i = (int)this.sDe.getTextSize();
    Object localObject;
    if (paramz != null)
    {
      localObject = ad.Rp(paramz.field_msgSvrId);
      ad.b localb = ad.beh().I((String)localObject, true);
      localb.k("prePublishId", "msg_" + paramz.field_msgSvrId);
      localb.k("preUsername", paramz.field_talker);
      localObject = l.a(localContext, str, i, null, (String)localObject);
      this.sDe.setMaxLines(2147483647);
      this.sDe.aL((CharSequence)localObject);
      if (!paramz.field_isExpand) {
        break label344;
      }
      this.sHK.setText(this.mContext.getString(d.i.esP));
      label159:
      i = com.tencent.mm.ci.a.kr(this.mContext);
      int j = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 72);
      localObject = this.sDe.nH(i - j, 2147483647);
      if (localObject == null) {
        break label408;
      }
    }
    label271:
    label408:
    for (i = ((com.tencent.neattextview.textview.layout.a)localObject).ikp();; i = 0)
    {
      if (i > 4)
      {
        if (!paramz.field_isExpand) {
          this.sDe.setMaxLines(4);
        }
        this.sHK.setVisibility(0);
        if (paramz.field_isExpand)
        {
          this.sHK.setText(d.i.esP);
          label255:
          this.sHK.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6041);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTextItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (!paramz.field_isExpand)
              {
                ap.this.sDe.setMaxLines(2147483647);
                paramz.field_isExpand = true;
                ap.this.sHK.setText(d.i.esP);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTextItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6041);
                return;
                ap.this.sDe.setMaxLines(4);
                paramz.field_isExpand = false;
                ap.this.sHK.setText(d.i.esQ);
              }
            }
          });
          localObject = (LinearLayout.LayoutParams)this.sDe.getLayoutParams();
          if (i > 4) {
            break label398;
          }
        }
      }
      for (((LinearLayout.LayoutParams)localObject).gravity = 17;; ((LinearLayout.LayoutParams)localObject).gravity = 19)
      {
        this.sDe.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.sHf.a(this, paramz);
        this.sHf.a(paramInt, paramz, this.sFW, this.sFV);
        AppMethodBeat.o(265200);
        return paramView;
        localObject = null;
        break;
        label344:
        this.sHK.setText(this.mContext.getString(d.i.esQ));
        break label159;
        this.sHK.setText(d.i.esQ);
        break label255;
        this.sDe.setMaxLines(2147483647);
        this.sHK.setVisibility(8);
        break label271;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ap
 * JD-Core Version:    0.7.0.1
 */