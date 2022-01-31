package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KProfessionEditView;
import com.tencent.kinda.gen.KProfessionEditViewOnSelectProfessionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KindaProfessionEditViewImpl
  extends MMKView<EditText>
  implements KProfessionEditView
{
  KProfessionEditViewOnSelectProfessionCallback callback;
  private Context mContext;
  private Profession mCurSelectedProfession;
  private EditText mEditText;
  private c<na> professionSelectedEventIListener;
  private final List<Profession> professions;
  
  public KindaProfessionEditViewImpl()
  {
    AppMethodBeat.i(144782);
    this.professions = new ArrayList();
    this.professionSelectedEventIListener = new KindaProfessionEditViewImpl.1(this);
    AppMethodBeat.o(144782);
  }
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(144783);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(2131304975);
    this.mEditText.setTextSize(16.0F);
    this.mContext = paramContext;
    paramContext = this.mEditText;
    AppMethodBeat.o(144783);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144786);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144786);
    return bool;
  }
  
  public String getProfessionName()
  {
    if (this.mCurSelectedProfession != null) {
      return this.mCurSelectedProfession.ues;
    }
    return null;
  }
  
  public int getProfessionType()
  {
    if (this.mCurSelectedProfession != null) {
      return this.mCurSelectedProfession.uet;
    }
    return 0;
  }
  
  public void setData(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144784);
    Object localObject = new bnv();
    paramITransmitKvData = paramITransmitKvData.getBinary("profession_list");
    try
    {
      ((bnv)localObject).parseFrom(paramITransmitKvData);
      paramITransmitKvData = ((bnv)localObject).xCe.iterator();
      while (paramITransmitKvData.hasNext())
      {
        localObject = (bnu)paramITransmitKvData.next();
        localObject = new Profession(((bnu)localObject).cDh, ((bnu)localObject).cDi);
        this.professions.add(localObject);
      }
    }
    catch (Exception paramITransmitKvData)
    {
      for (;;)
      {
        ab.e("base_MMKView", "profession list parse failed");
      }
      AppMethodBeat.o(144784);
    }
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144785);
    if (paramBoolean)
    {
      this.professionSelectedEventIListener.alive();
      if ((this.mContext instanceof BaseFrActivity))
      {
        ((BaseFrActivity)this.mContext).hideTenpayKB();
        Intent localIntent = new Intent(this.mContext, KindaWrapProfessionActivity.class);
        localIntent.putExtra("key_profession_list", (Parcelable[])this.professions.toArray(new Profession[this.professions.size()]));
        this.mContext.startActivity(localIntent);
      }
    }
    AppMethodBeat.o(144785);
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