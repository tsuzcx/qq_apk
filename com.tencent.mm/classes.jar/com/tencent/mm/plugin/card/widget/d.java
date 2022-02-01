package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends a
{
  private View wLi;
  private TextView wLj;
  private TextView wLk;
  private View wLl;
  private TextView wLm;
  private TextView wLn;
  private View wLo;
  private View wLp;
  private View wLq;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void doX()
  {
    AppMethodBeat.i(113904);
    this.wLi = this.wKN.findViewById(a.d.wkM);
    this.wLj = ((TextView)this.wKN.findViewById(a.d.wkO));
    this.wLk = ((TextView)this.wKN.findViewById(a.d.wkN));
    this.wLl = this.wKN.findViewById(a.d.weV);
    this.wLm = ((TextView)this.wKN.findViewById(a.d.weX));
    this.wLn = ((TextView)this.wKN.findViewById(a.d.weW));
    this.wLp = this.wKN.findViewById(a.d.whY);
    this.wLq = this.wKN.findViewById(a.d.wfy);
    AppMethodBeat.o(113904);
  }
  
  protected final void doY()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.wru.djK().ZdK != null) && (this.wru.djK().ZdK.size() > 0))
    {
      localObject3 = this.wru.djK().ZdK;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (aek)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.wLi.setVisibility(0);
          this.wLj.setText(((aek)localObject1).title);
          this.wLk.setText(((aek)localObject1).wsz);
          if (!TextUtils.isEmpty(((aek)localObject1).ZeV)) {
            this.wLj.setTextColor(l.alv(((aek)localObject1).ZeV));
          }
          if (!TextUtils.isEmpty(((aek)localObject1).ZeW)) {
            this.wLk.setTextColor(l.alv(((aek)localObject1).ZeW));
          }
        }
        if (localObject2 != null)
        {
          this.wLl.setVisibility(0);
          this.wLm.setText(((aek)localObject2).title);
          this.wLn.setText(((aek)localObject2).wsz);
          if (!TextUtils.isEmpty(((aek)localObject2).ZeV)) {
            this.wLm.setTextColor(l.alv(((aek)localObject2).ZeV));
          }
          if (!TextUtils.isEmpty(((aek)localObject2).ZeW)) {
            this.wLn.setTextColor(l.alv(((aek)localObject2).ZeW));
          }
        }
        label234:
        if ((!this.wru.djo()) || (this.wru.dju())) {
          break label358;
        }
        Log.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.wru.djF()) {
          break label886;
        }
        this.wLp.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.wru.djL().ZbI != null) || (!this.wru.djF())) {
        break label964;
      }
      this.wLq.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (aek)((LinkedList)localObject3).get(0);
      localObject2 = (aek)((LinkedList)localObject3).get(1);
      break;
      Log.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.wru.djL().Zbz != null) && (this.wru.djL().Zbz.size() > 0))
      {
        if (this.wLo == null) {
          this.wLo = ((ViewStub)this.wKN.findViewById(a.d.whB)).inflate();
        }
        this.wKN.findViewById(a.d.wfy).setVisibility(8);
        localObject1 = this.wLo;
        localObject3 = this.wru;
        localObject2 = this.qjL;
        localObject3 = ((b)localObject3).djL().Zbz;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(a.d.whF).setVisibility(0);
          localObject3 = (aek)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(a.d.wkZ)).setText(((aek)localObject3).title);
          ((TextView)((View)localObject1).findViewById(a.d.wkW)).setText(((aek)localObject3).wsz);
          ((View)localObject1).findViewById(a.d.whF).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((aek)localObject3).ZeV)) {
            ((TextView)((View)localObject1).findViewById(a.d.wkZ)).setTextColor(l.alv(((aek)localObject3).ZeV));
          }
          if (!TextUtils.isEmpty(((aek)localObject3).ZeW)) {
            ((TextView)((View)localObject1).findViewById(a.d.wkW)).setTextColor(l.alv(((aek)localObject3).ZeW));
          }
          ((View)localObject1).findViewById(a.d.whG).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        aek localaek = (aek)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(a.d.wkZ)).setText(localaek.title);
        ((TextView)((View)localObject1).findViewById(a.d.wkW)).setText(localaek.wsz);
        if (!TextUtils.isEmpty(localaek.ZeV)) {
          ((TextView)((View)localObject1).findViewById(a.d.wkZ)).setTextColor(l.alv(localaek.ZeV));
        }
        if (!TextUtils.isEmpty(localaek.ZeW)) {
          ((TextView)((View)localObject1).findViewById(a.d.wkW)).setTextColor(l.alv(localaek.ZeW));
        }
        localObject3 = (aek)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(a.d.wla)).setText(((aek)localObject3).title);
        ((TextView)((View)localObject1).findViewById(a.d.wkX)).setText(((aek)localObject3).wsz);
        if (!TextUtils.isEmpty(((aek)localObject3).ZeV)) {
          ((TextView)((View)localObject1).findViewById(a.d.wla)).setTextColor(l.alv(((aek)localObject3).ZeV));
        }
        if (!TextUtils.isEmpty(((aek)localObject3).ZeW)) {
          ((TextView)((View)localObject1).findViewById(a.d.wkX)).setTextColor(l.alv(((aek)localObject3).ZeW));
        }
        ((View)localObject1).findViewById(a.d.whF).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(a.d.whG).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.wLo != null) {
        this.wLo.setVisibility(8);
      }
      this.wKN.findViewById(a.d.wfy).setVisibility(8);
      break label265;
      label886:
      this.wLp.setVisibility(0);
      localObject1 = (TextView)this.wLp.findViewById(a.d.whN);
      if (!TextUtils.isEmpty(this.wru.djK().Zeh)) {
        ((TextView)localObject1).setText(this.wru.djK().Zeh);
      } else {
        n.i((TextView)localObject1, this.wru.djL().status);
      }
    }
    label964:
    this.wLq.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */