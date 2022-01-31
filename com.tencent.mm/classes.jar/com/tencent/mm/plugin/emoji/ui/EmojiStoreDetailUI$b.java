package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.ArrayList;

final class EmojiStoreDetailUI$b
  extends EmojiStoreDetailUI.a
{
  private ArrayList<EmojiInfo> lnB;
  
  public EmojiStoreDetailUI$b(EmojiStoreDetailUI paramEmojiStoreDetailUI)
  {
    super(paramEmojiStoreDetailUI);
    AppMethodBeat.i(53443);
    this.lnB = new ArrayList();
    this.lnB = ((ArrayList)i.getEmojiStorageMgr().yNn.Kw(com.tencent.mm.plugin.emoji.h.a.bnx()));
    AppMethodBeat.o(53443);
  }
  
  private EmojiInfo ur(int paramInt)
  {
    AppMethodBeat.i(53445);
    if (this.lnB == null)
    {
      AppMethodBeat.o(53445);
      return null;
    }
    EmojiInfo localEmojiInfo = (EmojiInfo)this.lnB.get(paramInt);
    AppMethodBeat.o(53445);
    return localEmojiInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(53444);
    if (this.lnB == null)
    {
      AppMethodBeat.o(53444);
      return 0;
    }
    int i = this.lnB.size();
    AppMethodBeat.o(53444);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(53446);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(EmojiStoreDetailUI.w(this.lnA)).inflate(2130969384, null);
      paramViewGroup = new EmojiStoreDetailUI.c(this.lnA, paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.lnC.setBackgroundResource(2130840356);
      localObject = ur(paramInt);
      if (!bo.isNullOrNil(((EmojiInfo)localObject).getContent())) {
        break label129;
      }
    }
    label129:
    for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
    {
      localObject = localObject.split("\\.")[0];
      o.ahG().a((String)localObject, paramViewGroup.lnC, g.bkS());
      AppMethodBeat.o(53446);
      return paramView;
      paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.b
 * JD-Core Version:    0.7.0.1
 */