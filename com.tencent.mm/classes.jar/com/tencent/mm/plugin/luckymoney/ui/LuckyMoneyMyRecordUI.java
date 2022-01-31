package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI
  extends LuckyMoneyBaseUI
{
  private int Fb;
  private View gyT;
  private boolean icT;
  private ImageView kPy;
  private TextView kQD;
  private int mType;
  private List<com.tencent.mm.plugin.luckymoney.model.r> oja;
  private TextView ojg;
  public String opu;
  private boolean orF;
  private Map<String, Integer> orM;
  public String orO;
  private MMLoadMoreListView osm;
  private e osn;
  private TextView otQ;
  private TextView otR;
  private TextView otS;
  private TextView otT;
  private TextView otU;
  private TextView otV;
  private TextView otW;
  private String otX;
  private int otY;
  public List<String> otZ;
  
  public LuckyMoneyMyRecordUI()
  {
    AppMethodBeat.i(42770);
    this.Fb = 0;
    this.oja = new LinkedList();
    this.orM = new HashMap();
    this.orF = true;
    this.icT = false;
    this.otY = -1;
    this.otZ = new ArrayList();
    this.orO = "";
    this.opu = "";
    AppMethodBeat.o(42770);
  }
  
  private void bNR()
  {
    AppMethodBeat.i(42775);
    this.icT = true;
    if (this.Fb == 0) {
      this.orO = "";
    }
    doSceneProgress(new ai(11, this.Fb, this.mType, this.otX, "v1.0", this.orO));
    AppMethodBeat.o(42775);
  }
  
  private void bOb()
  {
    AppMethodBeat.i(42773);
    this.otW.setVisibility(8);
    this.gyT.findViewById(2131825708).setVisibility(8);
    String str;
    if (this.mType == 1)
    {
      setMMTitle(getString(2131301256));
      str = getString(2131301309, new Object[] { com.tencent.mm.model.r.Zp() });
      x.a(getContext(), this.otQ, str);
      this.otS.setText(2131301315);
      this.osn = new f(getContext());
      this.otW.setVisibility(0);
    }
    for (;;)
    {
      this.osm.setAdapter(this.osn);
      a.b.a(this.kPy, com.tencent.mm.model.r.Zn(), 0.0F, false);
      this.otV.setText(getString(2131301298, new Object[] { bo.nullAsNil(this.otX) }));
      AppMethodBeat.o(42773);
      return;
      setMMTitle(getString(2131301254));
      str = getString(2131301296, new Object[] { com.tencent.mm.model.r.Zp() });
      x.a(getContext(), this.otQ, str);
      this.otS.setText(2131301297);
      this.osn = new d(getContext());
      this.gyT.findViewById(2131825708).setVisibility(0);
    }
  }
  
  private int bOc()
  {
    if (this.mType == 1) {
      return 8;
    }
    return 9;
  }
  
  public int getLayoutId()
  {
    return 2130970035;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42772);
    setBackBtn(new LuckyMoneyMyRecordUI.1(this));
    addIconOptionMenu(0, 2131230740, new LuckyMoneyMyRecordUI.2(this));
    this.kQD = ((TextView)findViewById(2131825719));
    this.osm = ((MMLoadMoreListView)findViewById(2131825718));
    this.gyT = LayoutInflater.from(this).inflate(2130970033, null);
    this.osm.addHeaderView(this.gyT);
    this.kPy = ((ImageView)this.gyT.findViewById(2131825705));
    this.otQ = ((TextView)this.gyT.findViewById(2131825706));
    this.ojg = ((TextView)this.gyT.findViewById(2131825707));
    this.otR = ((TextView)this.gyT.findViewById(2131825709));
    this.otS = ((TextView)this.gyT.findViewById(2131825710));
    this.otT = ((TextView)this.gyT.findViewById(2131825711));
    this.otU = ((TextView)this.gyT.findViewById(2131825712));
    this.otV = ((TextView)this.gyT.findViewById(2131825703));
    this.otW = ((TextView)this.gyT.findViewById(2131825713));
    this.osm.setOnItemClickListener(new LuckyMoneyMyRecordUI.3(this));
    this.osm.setOnItemLongClickListener(new LuckyMoneyMyRecordUI.4(this));
    this.osm.setOnLoadMoreListener(new LuckyMoneyMyRecordUI.5(this));
    this.kPy.setOnClickListener(new LuckyMoneyMyRecordUI.6(this));
    bOb();
    AppMethodBeat.o(42772);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42771);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690252));
    setActionbarElementColor(getResources().getColor(2131690237));
    this.mType = getIntent().getIntExtra("key_type", 2);
    initView();
    bNR();
    h.qsU.e(11701, new Object[] { Integer.valueOf(bOc()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(42771);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42774);
    if ((paramm instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramm;
        paramm = paramString.opr.onL;
        this.orO = paramString.opa;
        this.opu = paramString.opu;
        Object localObject2;
        if (this.Fb == 0)
        {
          this.otZ = paramString.ops;
          this.otX = paramString.opt;
          localObject1 = findViewById(2131825702);
          localObject2 = (ImageView)findViewById(2131825704);
          if (this.otZ.size() > 1)
          {
            ((ImageView)localObject2).setVisibility(0);
            ((View)localObject1).setOnClickListener(new LuckyMoneyMyRecordUI.7(this));
          }
          this.otV.setText(getString(2131301298, new Object[] { this.otX }));
        }
        Object localObject1 = paramString.opr;
        if (localObject1 != null)
        {
          if (this.mType != 1) {
            break label386;
          }
          this.ojg.setText(com.tencent.mm.wallet_core.ui.e.E(((q)localObject1).oom / 100.0D));
          localObject1 = ((q)localObject1).ool;
          Object localObject3 = getString(2131301314, new Object[] { localObject1 });
          localObject2 = new ForegroundColorSpan(getResources().getColor(2131690235));
          paramInt1 = ((String)localObject3).indexOf((String)localObject1);
          localObject3 = new SpannableString((CharSequence)localObject3);
          ((SpannableString)localObject3).setSpan(localObject2, paramInt1, ((String)localObject1).length() + paramInt1, 33);
          this.otW.setText((CharSequence)localObject3);
        }
        while (paramm != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 < paramm.size())
            {
              localObject1 = (com.tencent.mm.plugin.luckymoney.model.r)paramm.get(paramInt1);
              if (!this.orM.containsKey(((com.tencent.mm.plugin.luckymoney.model.r)localObject1).ojA))
              {
                this.oja.add(paramm.get(paramInt1));
                this.orM.put(((com.tencent.mm.plugin.luckymoney.model.r)localObject1).ojA, Integer.valueOf(1));
              }
              paramInt1 += 1;
              continue;
              label386:
              this.ojg.setText(com.tencent.mm.wallet_core.ui.e.E(((q)localObject1).ook / 100.0D));
              this.otR.setText(((q)localObject1).ooj);
              this.otT.setText(((q)localObject1).nao);
              break;
            }
          }
          this.Fb += paramm.size();
          this.orF = paramString.bNr();
          this.icT = false;
          this.osn.ci(this.oja);
        }
        if ((this.oja == null) || (this.oja.size() == 0))
        {
          this.kQD.setVisibility(0);
          if (!this.orF) {
            break label560;
          }
          this.osm.dDY();
        }
        for (;;)
        {
          AppMethodBeat.o(42774);
          return true;
          this.kQD.setVisibility(8);
          break;
          label560:
          this.osm.dDZ();
        }
      }
      this.opu = null;
    }
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(42774);
        return false;
      } while (!(paramm instanceof aj));
      i = this.otY;
      this.otY = -1;
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.osn.yz(i);
    if (paramString != null)
    {
      Toast.makeText(this, 2131301248, 0).show();
      this.osn.a(paramString);
      this.osn.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(42774);
      return true;
      ab.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI
 * JD-Core Version:    0.7.0.1
 */