package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KProfessionEditView;
import com.tencent.kinda.gen.KProfessionEditViewOnSelectProfessionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qw;
import com.tencent.mm.f.a.qw.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KindaProfessionEditViewImpl
  extends MMKView<View>
  implements KProfessionEditView
{
  private byte _hellAccFlag_;
  KProfessionEditViewOnSelectProfessionCallback callback;
  private Context mContext;
  private Profession mCurSelectedProfession;
  private EditText mEditText;
  private IListener<qw> professionSelectedEventIListener;
  private final List<Profession> professions;
  
  public KindaProfessionEditViewImpl()
  {
    AppMethodBeat.i(18924);
    this.professions = new ArrayList();
    this.professionSelectedEventIListener = new IListener()
    {
      public boolean callback(qw paramAnonymousqw)
      {
        AppMethodBeat.i(18922);
        if ("flag_activity_close_WalletSelectProfessionUI".equals(paramAnonymousqw.fPI.fPJ)) {
          KindaProfessionEditViewImpl.this.professionSelectedEventIListener.dead();
        }
        for (;;)
        {
          AppMethodBeat.o(18922);
          return false;
          Log.i("base_MMKView", "profession_name:" + paramAnonymousqw.fPI.fPJ + " profession_type:" + paramAnonymousqw.fPI.fPK);
          KindaProfessionEditViewImpl.access$102(KindaProfessionEditViewImpl.this, new Profession(paramAnonymousqw.fPI.fPJ, paramAnonymousqw.fPI.fPK));
          KindaProfessionEditViewImpl.this.mEditText.setText(KindaProfessionEditViewImpl.this.mCurSelectedProfession.OLY);
          if (KindaProfessionEditViewImpl.this.callback != null) {
            KindaProfessionEditViewImpl.this.callback.onSelectProfession(KindaProfessionEditViewImpl.this.mCurSelectedProfession.OLY, KindaProfessionEditViewImpl.this.mCurSelectedProfession.OLZ);
          }
        }
      }
    };
    AppMethodBeat.o(18924);
  }
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(18930);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(R.string.wallet_card_private_info_profession_hint);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(paramContext, 17.0F));
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mContext = paramContext;
    paramContext = new LayoutWrapper(paramContext, this.mEditText);
    AppMethodBeat.o(18930);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18929);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18929);
    return bool;
  }
  
  public String getProfessionName()
  {
    if (this.mCurSelectedProfession != null) {
      return this.mCurSelectedProfession.OLY;
    }
    return null;
  }
  
  public int getProfessionType()
  {
    if (this.mCurSelectedProfession != null) {
      return this.mCurSelectedProfession.OLZ;
    }
    return 0;
  }
  
  public void setData(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18926);
    Object localObject = new doq();
    paramITransmitKvData = paramITransmitKvData.getBinary("profession_list");
    try
    {
      ((doq)localObject).parseFrom(paramITransmitKvData);
      this.professions.clear();
      paramITransmitKvData = ((doq)localObject).TVQ.iterator();
      while (paramITransmitKvData.hasNext())
      {
        localObject = (dop)paramITransmitKvData.next();
        localObject = new Profession(((dop)localObject).fPJ, ((dop)localObject).fPK);
        this.professions.add(localObject);
      }
    }
    catch (Exception paramITransmitKvData)
    {
      for (;;)
      {
        Log.e("base_MMKView", "profession list parse failed");
      }
      AppMethodBeat.o(18926);
    }
  }
  
  public void setDefaultProfession(int paramInt, String paramString)
  {
    AppMethodBeat.i(18927);
    this.mCurSelectedProfession = new Profession(paramString, paramInt);
    this.mEditText.setText(this.mCurSelectedProfession.OLY);
    AppMethodBeat.o(18927);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18928);
    if (paramBoolean)
    {
      this.professionSelectedEventIListener.alive();
      if ((this.mContext instanceof BaseFrActivity))
      {
        ((BaseFrActivity)this.mContext).hideTenpayKB();
        Object localObject = new Intent(this.mContext, KindaWrapProfessionActivity.class);
        ((Intent)localObject).putExtra("key_profession_list", (Parcelable[])this.professions.toArray(new Profession[this.professions.size()]));
        Context localContext = this.mContext;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/kinda/framework/widget/base/KindaProfessionEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/kinda/framework/widget/base/KindaProfessionEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(18928);
  }
  
  public void setOnSelectProfessionCallback(KProfessionEditViewOnSelectProfessionCallback paramKProfessionEditViewOnSelectProfessionCallback)
  {
    this.callback = paramKProfessionEditViewOnSelectProfessionCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaProfessionEditViewImpl
 * JD-Core Version:    0.7.0.1
 */