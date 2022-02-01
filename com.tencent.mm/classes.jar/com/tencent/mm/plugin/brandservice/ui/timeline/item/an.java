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
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class an
  extends ag
{
  public View clickArea;
  public MMNeat7extView ptR;
  public TextView pyh;
  
  public final View b(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(6042);
    super.a(paramContext, paramb);
    if (this.puO != null)
    {
      paramContext = this.puO;
      AppMethodBeat.o(6042);
      return paramContext;
    }
    this.puO = View.inflate(paramContext, 2131493290, null);
    cne();
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131297579));
    this.pyh = ((TextView)this.puO.findViewById(2131297580));
    this.ptR.setOnTouchListener(new h(this.ptR, new o(this.ptR.getContext())));
    this.clickArea = this.puO.findViewById(2131297553);
    paramContext = this.puO;
    AppMethodBeat.o(6042);
    return paramContext;
  }
  
  public final View b(final z paramz, int paramInt, View paramView)
  {
    AppMethodBeat.i(194974);
    Context localContext = this.mContext;
    String str = paramz.field_content;
    int i = (int)this.ptR.getTextSize();
    Object localObject;
    if (paramz != null)
    {
      localObject = ad.JX(paramz.field_msgSvrId);
      ad.b localb = ad.aVe().G((String)localObject, true);
      localb.l("prePublishId", "msg_" + paramz.field_msgSvrId);
      localb.l("preUsername", paramz.field_talker);
      localObject = l.a(localContext, str, i, 1, null, (String)localObject);
      this.ptR.setMaxLines(2147483647);
      this.ptR.aw((CharSequence)localObject);
      if (!paramz.field_isExpand) {
        break label343;
      }
      this.pyh.setText(this.mContext.getString(2131756767));
      label159:
      i = com.tencent.mm.cb.a.jn(this.mContext);
      int j = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 72);
      localObject = this.ptR.mq(i - j, 2147483647);
      if (localObject == null) {
        break label405;
      }
    }
    label270:
    label405:
    for (i = ((com.tencent.neattextview.textview.layout.a)localObject).hiG();; i = 0)
    {
      if (i > 4)
      {
        if (!paramz.field_isExpand) {
          this.ptR.setMaxLines(4);
        }
        this.pyh.setVisibility(0);
        if (paramz.field_isExpand)
        {
          this.pyh.setText(2131756767);
          label254:
          this.pyh.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6041);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTextItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (!paramz.field_isExpand)
              {
                an.this.ptR.setMaxLines(2147483647);
                paramz.field_isExpand = true;
                an.this.pyh.setText(2131756767);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineTextItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(6041);
                return;
                an.this.ptR.setMaxLines(4);
                paramz.field_isExpand = false;
                an.this.pyh.setText(2131756768);
              }
            }
          });
          localObject = (LinearLayout.LayoutParams)this.ptR.getLayoutParams();
          if (i > 4) {
            break label395;
          }
        }
      }
      for (((LinearLayout.LayoutParams)localObject).gravity = 17;; ((LinearLayout.LayoutParams)localObject).gravity = 19)
      {
        this.ptR.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.pxE.a(this, paramz);
        this.pxE.a(paramInt, paramz, this.pwA, this.pwz);
        AppMethodBeat.o(194974);
        return paramView;
        localObject = null;
        break;
        label343:
        this.pyh.setText(this.mContext.getString(2131756768));
        break label159;
        this.pyh.setText(2131756768);
        break label254;
        this.ptR.setMaxLines(2147483647);
        this.pyh.setVisibility(8);
        break label270;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.an
 * JD-Core Version:    0.7.0.1
 */