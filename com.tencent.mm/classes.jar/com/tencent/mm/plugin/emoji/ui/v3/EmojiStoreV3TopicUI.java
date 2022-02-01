package com.tencent.mm.plugin.emoji.ui.v3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.emoji.ui.v3.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3TopicUI;", "Lcom/tencent/mm/plugin/emoji/ui/BaseEmojiStoreUI;", "()V", "TAG", "", "emotionListBuf", "", "entrance_scene", "", "topicADUrl", "topicDesc", "topicID", "topicIconUrl", "topicName", "getDownloadEntranceScene", "getEmoticonStoreActionStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;", "action", "data", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/EmotionExpose18662Data;", "getEmotionListBuf", "getForceOrientation", "getGoDetailIntent", "Landroid/content/Intent;", "item", "Lcom/tencent/mm/plugin/emoji/adapter/data/EmotionItem;", "getNetSceneGetEmotionListType", "getPrecedingScene", "initData", "", "emotionList", "Lcom/tencent/mm/plugin/emoji/model/EmotionListReqModel;", "byCache", "", "addTuzi", "initView", "isNeedReport18662Action", "isUseHeader", "newInstanceAdapter", "Lcom/tencent/mm/plugin/emoji/adapter/data/BaseEmojiListAdapter;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "report12740", "reportExposeAction18662", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3TopicUI
  extends BaseEmojiStoreUI
{
  private final String TAG = "MicroMsg.EmojiStoreV3TopicUI";
  private String xUk = "";
  private String xUl = "";
  private String xUm = "";
  private String xUn = "";
  private int yaR;
  private byte[] yaS;
  private int yaT = -1;
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(270517);
    paramb = b(paramInt, paramb);
    if (paramb != null) {
      paramb.bMH();
    }
    AppMethodBeat.o(270517);
  }
  
  public final void a(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(270474);
    super.a(paramm, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(270474);
  }
  
  public final bw b(int paramInt, b paramb)
  {
    AppMethodBeat.i(270526);
    bw localbw = new bw();
    localbw.iuF = 4;
    localbw.iqv = this.yaT;
    Object localObject1 = com.tencent.mm.plugin.emoji.ui.v3.b.a.ycU;
    localbw.iuE = com.tencent.mm.plugin.emoji.ui.v3.b.a.dDm();
    localbw.ipB = paramInt;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(270526);
      return localbw;
    }
    for (;;)
    {
      int i;
      int m;
      int k;
      int j;
      try
      {
        i = this.mListView.getFirstVisiblePosition();
        m = this.mListView.getLastVisiblePosition();
        if (m - i <= 0)
        {
          Log.i(this.TAG, "getEmoticonStoreActionStruct failed, start:" + i + ", end:" + m);
          AppMethodBeat.o(270526);
          return localbw;
        }
        paramb = new StringBuilder();
        localObject1 = new StringBuilder();
        StringBuilder localStringBuilder = new StringBuilder();
        paramInt = 1;
        if (i < m)
        {
          k = i + 1;
          Object localObject2 = this.xNj.Kd(i);
          j = paramInt;
          if (localObject2 == null) {
            break label393;
          }
          localObject2 = ((com.tencent.mm.plugin.emoji.a.a.f)localObject2).xHE;
          j = paramInt;
          if (localObject2 == null) {
            break label393;
          }
          if (paramInt == 0)
          {
            paramb.append("#");
            ((StringBuilder)localObject1).append("#");
            localStringBuilder.append("#");
          }
          paramb.append(((cjb)localObject2).ProductID);
          ((StringBuilder)localObject1).append(((cjb)localObject2).Zul);
          localStringBuilder.append(i + 1);
          j = 0;
          break label393;
        }
        localbw.lg(paramb.toString());
        localbw.lh(((StringBuilder)localObject1).toString());
        localbw.li(localStringBuilder.toString());
      }
      catch (Exception paramb)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramb, "", new Object[0]);
      }
      break;
      if (paramb == null) {
        break;
      }
      localbw.lg(paramb.ycW);
      localbw.li(String.valueOf(paramb.index));
      localbw.lh(paramb.hZn);
      break;
      label393:
      do
      {
        i = k;
        paramInt = j;
        break;
      } while (k < m);
    }
  }
  
  public final int dAR()
  {
    return this.yaT;
  }
  
  public final int dAS()
  {
    return 5;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.a dAT()
  {
    AppMethodBeat.i(270495);
    com.tencent.mm.plugin.emoji.a.a.a locala = (com.tencent.mm.plugin.emoji.a.a.a)new com.tencent.mm.plugin.emoji.a.f((Context)getContext());
    AppMethodBeat.o(270495);
    return locala;
  }
  
  public final boolean dAX()
  {
    return false;
  }
  
  public final int dBa()
  {
    return 13;
  }
  
  public final byte[] dBi()
  {
    return this.yaS;
  }
  
  public final boolean dBo()
  {
    return true;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(270463);
    super.initView();
    setMMTitle(this.xUk);
    super.initView();
    showOptionMenu(0, false);
    AppMethodBeat.o(270463);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270460);
    String str2 = getIntent().getStringExtra("topic_name");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.xUk = str1;
    this.yaR = getIntent().getIntExtra("topic_id", -1);
    str2 = getIntent().getStringExtra("topic_ad_url");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.xUn = str1;
    str2 = getIntent().getStringExtra("topic_icon_url");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.xUl = str1;
    str2 = getIntent().getStringExtra("topic_desc");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.xUm = str1;
    this.yaS = getIntent().getByteArrayExtra("emotion_list_buf");
    this.yaT = getIntent().getIntExtra("entrance_scene", 11);
    super.onCreate(paramBundle);
    h.OAn.b(12740, new Object[] { Integer.valueOf(3), "", "", Integer.valueOf(dBb()), Integer.valueOf(this.yaT), Integer.valueOf(11) });
    AppMethodBeat.o(270460);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(270467);
    super.onResume();
    AppMethodBeat.o(270467);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3TopicUI
 * JD-Core Version:    0.7.0.1
 */